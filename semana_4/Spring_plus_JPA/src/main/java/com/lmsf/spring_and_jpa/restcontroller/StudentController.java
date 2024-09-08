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


// Rest Controller to expose the service layer through endpoints accessible through HTTP requests:
@RestController
@RequestMapping("/")
public class StudentController {
	
	// Inject the service's implementation to the controller
	@Autowired
	private StudentService studentService;
	
	
	//GET Requests examples:
	
	@GetMapping("/students")
	public List<Student> findAllStudents() {
		return studentService.findAll();
	}
	
	@GetMapping("/students/size")
	public String countStudents() {
		return "Number of students in database : " + studentService.countNumberOfStudents();
	}
	
	@GetMapping("/students/gender/{gender}")
	public List<Student> findStudentsByGender(@PathVariable Gender gender) {
		return studentService.findStudentsByGender(gender);
	}
	
	@GetMapping("/students/no-phone-number")
	public List<Student> findStudentsWithoutNumber() {
		return studentService.findStudentsWithoutPhoneNum();
	}

	@GetMapping("/student/{id}")
	public Student findStudentById(@PathVariable int id) {
		Student retrievedStudent =  studentService.findByID(id);
		
		return retrievedStudent;
	}
	
	@GetMapping("/student/{first_name}/{last_name}")
	public List<Student> searchByFirstAndLastName(@PathVariable(name = "first_name") String firstName,
										   @PathVariable(name = "last_name") String lastName) {
		
		List<Student> students =  studentService.findStudentsByName(firstName, lastName);
		
		if(students.isEmpty())
			throw new IllegalStateException("No student with first name \""+firstName+"\" and last name \""+lastName+"\" exists in the database...");
		
		return students;
	}
	
	// POST Request to add a new student to the database:
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student newStudent) {
		
		newStudent.setId(0);
		
		return studentService.saveStudent(newStudent);
	}
	
	// PUT Request to update an existing student from the database:
	@PutMapping("/student")
	public Student updateStudent(@RequestBody Student student) {
		
		return studentService.saveStudent(student);
	
	}
	
	// DELETE Request to remove a student from the database given their ID:
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable int id) {
		
		studentService.deleteStudent(id);
		
		return "Student with ID #"+id+" was deleted successfully.";
	}
}