package com.lmsf.spring_and_jpa.service;

import java.util.List;

import com.lmsf.spring_and_jpa.entity.Student;
import com.lmsf.spring_and_jpa.entity.Student.Gender;

public interface StudentService {
	//CREATE
		Student saveStudent(Student newStudent);
		
		//READ
		Student findByID(int id);
		long countNumberOfStudents();
		List<Student> findAll();
		List<Student> retrieveStudentsByName(String firstName, String lastName);
		List<Student> findStudentsWithoutPhoneNum();
		List<Student> retrieveStudentsByGender(Gender gender);
		
		
		//DELETE
		void deleteStudent(int id);
}
