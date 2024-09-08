package com.lmsf.spring_data_jpa.service;

import java.util.List;
import java.util.Optional;

import com.lmsf.spring_data_jpa.entity.Student;
import com.lmsf.spring_data_jpa.entity.Student.Gender;

public interface StudentService {
		//CREATE
		Student saveStudent(Student newStudent);
		
		//READ
		Optional<Student> findByID(int id);
		
		
		long countNumberOfStudents();
		List<Student> findAll();
		List<Student> findByFirstName(String firstName);
		List<Student> findStudentsWithoutPhoneNum();
		List<Student> findStudentsByGender(Gender gender);
		
		
		//DELETE
		void deleteStudent(int id);
}
