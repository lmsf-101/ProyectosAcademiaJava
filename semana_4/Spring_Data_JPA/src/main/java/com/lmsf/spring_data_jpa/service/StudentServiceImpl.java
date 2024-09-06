package com.lmsf.spring_data_jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmsf.spring_data_jpa.dao.StudentRepository;
import com.lmsf.spring_data_jpa.entity.Student;
import com.lmsf.spring_data_jpa.entity.Student.Gender;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentDAO;
	
	
//	public StudentServiceImpl(StudentDAO studentDAO) {
//		this.studentDAO = studentDAO;
//	}

	@Override
	@Transactional
	public Student saveStudent(Student newStudent) {
		
		Student addedStudent = studentDAO.save(newStudent);
		
		return addedStudent;
		
	}

	@Override
	public Optional<Student> findByID(int id) {
		//System.out.println("Searching for student with ID #" + id);
		
		Optional<Student> retrievedStudent = studentDAO.findById(id);
		
//		if(retrievedStudent == null)
//			System.err.println("\nNo student with ID #"+id+ " was found...");
//		
//		else
//			System.out.println("\nStudent retrieved : \n"+retrievedStudent);
		
		return retrievedStudent;
	}
	
	@Override
	public long countNumberOfStudents() {
		return studentDAO.count();
	}
	
	@Override
	public List<Student> findAll() {
		return studentDAO.findAll();
	}

	@Override
	public List<Student> findByFirstName(String firstName) {
		//System.out.println("Retrieving students with name : " + firstName + " " + lastName);
		
		List<Student> students = studentDAO.findByFirstName(firstName);
		
//		System.out.println("STUDENTS : \n");
//		students.forEach(System.out::println);
		
		return students;
	}

	@Override
	public List<Student> findStudentsWithoutPhoneNum() {
		//System.out.println("Retrieving students without a phone number: ");
		
		List<Student> students = studentDAO.findStudentsWithoutPhoneNum();
		
		//System.out.println("STUDENTS : \n");
		//students.forEach(System.out::println);
		
		return students;
	}

	@Override
	public List<Student> findStudentsByGender(Gender gender) {
		//System.out.println("Retrieving students by gender : " + gender.name());
		
		List<Student> students = studentDAO.findByGender(gender);
		
		//System.out.println("STUDENTS : \n");
		//students.forEach(System.out::println);
		
		return students;
	}

//	@Override
//	@Transactional
//	public Student updateStudent(Student student) {
//		System.out.println("Updating the student with ID #"+student.getId());
//		
//		//Student retrievedStudent = studentDAO.findByID(student.getId());
//				
//		studentDAO.updateStudent(student);
//		
//		System.out.println("Updated student.");
//		System.out.println("\nSTUDENT :\n" + student);
//		
//		return student;
//		
//	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		//System.out.println("Deleting the student from database with ID #"+id);
		
		studentDAO.deleteById(id);
		
		//System.out.println("Student deleted succesfully.");
	}

}
