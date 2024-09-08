package com.lmsf.spring_batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
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

// Spring Batch Configuration class for setting up the jobs / steps to execute:
@Configuration
@EnableBatchProcessing
public class StudentBatchConfig {
	
	// Inject the JPA repository to save the students row that meet the criteria into the database:
	@Autowired
	private StudentRepository studentRepository;
	
	@Bean
	public FlatFileItemReader<Student> reader() {
		
		// Generate a new FlatFileItemReader to read from:
		return new FlatFileItemReaderBuilder<Student>()
					.name("studentDataReader") // Name of the Reader instance
					.resource(new ClassPathResource("students_data.csv")) // Resource to read from
					.linesToSkip(1) // Skip the first line, as it contains the headers
					.delimited() // returns a DelimitedBuilder to break down the row in indv. fields
					.strict(false)
					.names("id", "firstName", "lastName", "dateOfBirth", "email", "gender", "phoneNumber") // Name of each field
					.fieldSetMapper(new BeanWrapperFieldSetMapper<Student>()) // Bridge between the extracted data and the Java domain object (Student)
					.targetType(Student.class) // Converts the set of fields into a Student object
					.build();
	}
	
	
	// ItemWriter method to write onto the database with the student that meets the criteria:
	@Bean
	public RepositoryItemWriter<Student> writer() {
		return new RepositoryItemWriterBuilder<Student>()
					// Set the JPA repository as the target location
					.repository(studentRepository)
					// Call it's save function to write the student data onto the database
					.methodName("save")
					.build();
	}
	
	// Method to generate the step:
	@Bean
	public Step firstStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
			RepositoryItemWriter<Student> writer
			) {
		return new StepBuilder("firstStep", jobRepository)
				.<Student, Student>chunk(20, transactionManager)
				.reader(reader()) // <- Apply the ItemReader method created above
				.processor((StudentProcessor) // <- Apply the ItemProcessor as a lambda expression
						student -> {
							// If the student has no contact info, add it to the table...
							if(student.getPhoneNumber().isEmpty() && student.getEmail().isEmpty()) {
								student.setEmail(null);
								student.setPhoneNumber(null);
								return student;
							}
							// If there's at least a contact info, ignore it...
							return null;	
						}
				)
				.writer(writer) // <- Apply the ItemWriter method created above
				.build();
	}
	
	// Method to generate the job:
	@Bean
	public Job runJob(JobRepository jobRepository, Step step1) {
		return new JobBuilder("runJob", jobRepository)
				.flow(step1)
				.end()
				.build();
	}
	
}
