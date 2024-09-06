package com.lmsf.spring_and_jpa.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmsf.spring_and_jpa.entity.Student;
import com.lmsf.spring_and_jpa.entity.Student.Gender;
import com.lmsf.spring_and_jpa.service.StudentService;

@RestController
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> findAllStudents() {
		return studentService.findAll();
	}
	
	@GetMapping("/students/size")
	public String countStudents() {
		return "Number of students in database : " + studentService.countNumberOfStudents();
	}
	
	@GetMapping("/students/gender/{gender}")
	public List<Student> searchByGender(@PathVariable Gender gender) {
		return studentService.retrieveStudentsByGender(gender);
	}
	
	@GetMapping("/students/no-phone-number")
	public List<Student> searchStudentsWithoutNumber() {
		return studentService.findStudentsWithoutPhoneNum();
	}

	@GetMapping("/student/{id}")
	public Student findStudentById(@PathVariable int id) {
		Student retrievedStudent =  studentService.findByID(id);
		
		if(retrievedStudent == null)
			throw new RuntimeException("No student with ID #"+id+" was found at the database...");
		
		return retrievedStudent;
	}
	
	@GetMapping("/student/{first_name}/{last_name}")
	public List<Student> searchByFirstAndLastName(@PathVariable(name = "first_name") String firstName,
										   @PathVariable(name = "last_name") String lastName) {
		
		List<Student> students =  studentService.retrieveStudentsByName(firstName, lastName);
		
		if(students.isEmpty())
			throw new IllegalStateException("No student with first name \""+firstName+"\" and last name \""+lastName+"\" exists in the database...");
		
		return students;
	}
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student newStudent) {
		
		newStudent.setId(0);
		
		return studentService.saveStudent(newStudent);
	}
	
	@PutMapping("/student")
	public Student updateStudent(@RequestBody Student student) {
		
		return studentService.saveStudent(student);
	
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable int id) {
		
		Student studentToDelete = studentService.findByID(id);
		
		if(studentToDelete == null)
			throw new RuntimeException("No student with ID #"+id+ " exists to delete....");
		
		studentService.deleteStudent(id);
		
		return "Student with ID #"+id+" was deleted successfully.";
	}
}