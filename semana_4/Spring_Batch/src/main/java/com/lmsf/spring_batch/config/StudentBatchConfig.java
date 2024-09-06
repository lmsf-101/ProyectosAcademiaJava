package com.lmsf.spring_batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;


import com.lmsf.spring_batch.entity.Student;
import com.lmsf.spring_batch.repository.StudentRepository;

@Configuration
public class StudentBatchConfig {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Bean
	public FlatFileItemReader<Student> reader() {
		return new FlatFileItemReaderBuilder<Student>()
					.name("studentDataReader")
					.resource(new ClassPathResource("students_data.csv"))
					.linesToSkip(1)
					.delimited()
					.strict(false)
					.names("id", "firstName", "lastName", "dateOfBirth", "email", "gender", "phoneNumber")
					.fieldSetMapper(new BeanWrapperFieldSetMapper<Student>())
					.targetType(Student.class)
					.build();
	}
	
	
	
//	private LineMapper<Cliente> lineMap() {
//		
//		DefaultLineMapper<Cliente> lm = new DefaultLineMapper<>();
//		
//		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
//		
//		lineTokenizer.setDelimiter(",");
//		lineTokenizer.setStrict(false);
//		lineTokenizer.setNames("id","nombre","apellido","correo","genero","telefono","pais","fechaNacimiento");
//		
//		BeanWrapperFieldSetMapper<Cliente> fieldSetMapper = new BeanWrapperFieldSetMapper<Cliente>();
//		
//		fieldSetMapper.setTargetType(Cliente.class);
//		
//		lm.setLineTokenizer(lineTokenizer); 
//		lm.setFieldSetMapper(fieldSetMapper); 
//		
//		return lm;
//	}
	
	
	@Bean
	public RepositoryItemWriter<Student> writer() {
		return new RepositoryItemWriterBuilder<Student>()
					.repository(studentRepository)
					.methodName("save")
					.build();
	}
	
	@Bean
	public Step firstStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
			RepositoryItemWriter<Student> writer
			) {
		return new StepBuilder("firstStep", jobRepository)
				.<Student, Student>chunk(20, transactionManager)
				.reader(reader())
				.processor((StudentProcessor)
						student -> {
							// If the student has no contact info, add it to the table...
							if(student.getPhoneNumber().isEmpty() && student.getEmail().isEmpty()) {
								student.setEmail(null);
								student.setPhoneNumber(null);
								return student;
							}
							
							return null;	
						}
				)
				.writer(writer)
				.build();
	}
	
	@Bean
	public Job runJob(JobRepository jobRepository, Step step1) {
		return new JobBuilder("runJob", jobRepository)
				.flow(step1)
				.end()
				.build();
	}
	
}
