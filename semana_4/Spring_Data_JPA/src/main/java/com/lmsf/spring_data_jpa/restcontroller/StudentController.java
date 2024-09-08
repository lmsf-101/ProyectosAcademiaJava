package com.lmsf.spring_data_jpa.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lmsf.spring_data_jpa.entity.Student;
import com.lmsf.spring_data_jpa.entity.Student.Gender;
import com.lmsf.spring_data_jpa.service.StudentService;

// REST CONTROLLER
@RestController
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
	public List<Student> findStudentsByGender(@PathVariable Gender gender) {
		return studentService.findStudentsByGender(gender);
	}
	
	@GetMapping("/students/no_phone_number")
	public List<Student> findStudentsWithoutNumber() {
		return studentService.findStudentsWithoutPhoneNum();
	}

	@GetMapping("/student/id/{id}")
	public Student findStudentById(@PathVariable int id) {
		Optional<Student> retrievedStudent =  studentService.findByID(id);
		
		return retrievedStudent.get();
	}
	
	@GetMapping("/student/first_name/{first_name}")
	public List<Student> findStudentByFirstName(@PathVariable(name = "first_name") String firstName) {
		
		List<Student> students =  studentService.findByFirstName(firstName);
		
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
		
		studentService.deleteStudent(id);
		
		return "Student with ID #"+id+" was deleted successfully.";
	}
}