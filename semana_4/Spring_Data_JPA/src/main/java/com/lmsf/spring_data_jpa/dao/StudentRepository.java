package com.lmsf.spring_data_jpa.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lmsf.spring_data_jpa.entity.Student;
import com.lmsf.spring_data_jpa.entity.Student.Gender;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	//CREATE
	//Student saveStudent(Student newStudent);
	
	//READ
	
	List<Student> findByFirstName(String firstName);
	
	List<Student> findByEmail(String email);
	
	@Query("SELECT s FROM Student s where s.phoneNumber IS NULL")
	List<Student> findStudentsWithoutPhoneNum();
	
	List<Student> findByGender(Gender gender);
	
	//List<Student> findAll();
	//List<Student> retrieveStudentsByName(String firstName, String lastName);
	//List<Student> findStudentsWithoutPhoneNum();
	//List<Student> retrieveStudentsByGender(Gender gender);
	
	
}
