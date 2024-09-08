package com.lmsf.spring_and_jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmsf.spring_and_jpa.dao.StudentDAO;
import com.lmsf.spring_and_jpa.entity.Student;
import com.lmsf.spring_and_jpa.entity.Student.Gender;

import jakarta.transaction.Transactional;

// Service Implementation
@Service
public class StudentServiceImpl implements StudentService{

	// Inject the JPA repository needed for interacting with the database:
	@Autowired
	private StudentDAO studentDAO;
	
	
	@Override
	@Transactional // <- Specify as a transaction process to ensure data consistency
	public Student saveStudent(Student newStudent) {
		
		Student addedStudent = studentDAO.saveStudent(newStudent);
		
		return addedStudent;
		
	}

	@Override
	public Student findByID(int id) {
		
		Student retrievedStudent = studentDAO.findByID(id);
		
		if(retrievedStudent == null) // <- If there was no student retrieved, throw a RuntimeException:
			throw new RuntimeException("\nNo student with ID #"+id+ " was found...");

		
		return retrievedStudent;
	}
	
	@Override
	public long countNumberOfStudents() {
		return studentDAO.countNumberOfStudents();
	}
	
	@Override
	public List<Student> findAll() {
		return studentDAO.findAll();
	}

	@Override
	public List<Student> findStudentsByName(String firstName, String lastName) {
		
		List<Student> students = studentDAO.findStudentsByName(firstName, lastName);

		return students;
	}

	@Override
	public List<Student> findStudentsWithoutPhoneNum() {
		
		List<Student> students = studentDAO.findStudentsWithoutPhoneNum();
		
		return students;
	}

	@Override
	public List<Student> findStudentsByGender(Gender gender) {
		
		List<Student> students = studentDAO.findStudentsByGender(gender);
		
		return students;
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		
		Student student = findByID(id);
		
		if(student == null) // <- If there was no student retrieved, throw a RuntimeException:
			throw new RuntimeException("\nNo student with ID #"+id+ " was found. No delete operation was made.");
		
		studentDAO.deleteStudent(id);
		
	}

}
