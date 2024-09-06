package com.lmsf.spring_and_jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmsf.spring_and_jpa.dao.StudentDAO;
import com.lmsf.spring_and_jpa.entity.Student;
import com.lmsf.spring_and_jpa.entity.Student.Gender;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDAO studentDAO;
	
	
//	public StudentServiceImpl(StudentDAO studentDAO) {
//		this.studentDAO = studentDAO;
//	}

	@Override
	@Transactional
	public Student saveStudent(Student newStudent) {
		
		Student addedStudent = studentDAO.saveStudent(newStudent);
		
		return addedStudent;
		
	}

	@Override
	public Student findByID(int id) {
		//System.out.println("Searching for student with ID #" + id);
		
		Student retrievedStudent = studentDAO.findByID(id);
		
//		if(retrievedStudent == null)
//			System.err.println("\nNo student with ID #"+id+ " was found...");
//		
//		else
//			System.out.println("\nStudent retrieved : \n"+retrievedStudent);
		
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
	public List<Student> retrieveStudentsByName(String firstName, String lastName) {
		//System.out.println("Retreiving students with name : " + firstName + " " + lastName);
		
		List<Student> students = studentDAO.retrieveStudentsByName(firstName, lastName);
		
//		System.out.println("STUDENTS : \n");
//		students.forEach(System.out::println);
		
		return students;
	}

	@Override
	public List<Student> findStudentsWithoutPhoneNum() {
		//System.out.println("Retreiving students without a phone number: ");
		
		List<Student> students = studentDAO.findStudentsWithoutPhoneNum();
		
		//System.out.println("STUDENTS : \n");
		//students.forEach(System.out::println);
		
		return students;
	}

	@Override
	public List<Student> retrieveStudentsByGender(Gender gender) {
		//System.out.println("Retreiving students by gender : " + gender.name());
		
		List<Student> students = studentDAO.retrieveStudentsByGender(gender);
		
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
		
		studentDAO.deleteStudent(id);
		
		//System.out.println("Student deleted succesfully.");
	}

}
