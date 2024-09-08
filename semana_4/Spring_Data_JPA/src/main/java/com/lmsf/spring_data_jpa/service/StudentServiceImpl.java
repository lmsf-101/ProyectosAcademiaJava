package com.lmsf.spring_data_jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmsf.spring_data_jpa.dao.StudentRepository;
import com.lmsf.spring_data_jpa.entity.Student;
import com.lmsf.spring_data_jpa.entity.Student.Gender;

import jakarta.transaction.Transactional;


// SERVICE
@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentDAO;
	
	
	@Override
	@Transactional
	public Student saveStudent(Student newStudent) {
		
		Student addedStudent = studentDAO.save(newStudent); // <- Method provided by Spring Data JPA
		
		return addedStudent;
		
	}

	@Override
	public Optional<Student> findByID(int id) {
		
		Optional<Student> retrievedStudent = studentDAO.findById(id); // As well as this one!
		
		if(retrievedStudent.isEmpty())
			throw new RuntimeException("No student with ID #"+id+" was found at the database...");
		
		return retrievedStudent;
	}
	
	@Override
	public long countNumberOfStudents() {
		return studentDAO.count(); // And this one.
	}
	
	@Override
	public List<Student> findAll() {
		return studentDAO.findAll();
	}

	@Override
	public List<Student> findByFirstName(String firstName) {
		
		List<Student> students = studentDAO.findByFirstName(firstName);
		
		if(students.isEmpty())
			throw new IllegalStateException("No student with first name "+firstName+" exists in the database...");
		
		return students;
	}

	@Override
	public List<Student> findStudentsWithoutPhoneNum() {
		
		List<Student> students = studentDAO.findStudentsWithoutPhoneNum();
		
		return students;
	}

	@Override
	public List<Student> findStudentsByGender(Gender gender) {
		
		List<Student> students = studentDAO.findByGender(gender);

		return students;
	}


	@Override
	@Transactional
	public void deleteStudent(int id) {
		
		Optional<Student> studentToDelete = findByID(id);
		
		studentDAO.deleteById(id);
		
	}

}
