package com.lmsf.spring_batch.config;

import org.springframework.batch.item.ItemProcessor;

import com.lmsf.spring_batch.entity.Student;

@FunctionalInterface
public interface StudentProcessor extends ItemProcessor<Student, Student> {
	
	
	Student process(Student student) throws Exception;
}
