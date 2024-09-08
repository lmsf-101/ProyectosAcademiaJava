package com.lmsf.spring_data_jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lmsf.spring_data_jpa.entity.Student;
import com.lmsf.spring_data_jpa.entity.Student.Gender;

// SPRING DATA JPA REPOSITORY
@Repository								// Automatically generates a repository implementation!
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	// Query method based on the naming convention (Retrieve students based on the firstName attribute)
	List<Student> findByFirstName(String firstName);
	
	List<Student> findByEmail(String email);
	
	List<Student> findByGender(Gender gender);
	
	// Custom JPQL Query without the need of an concrete method:
	@Query("SELECT s FROM Student s where s.phoneNumber IS NULL")
	List<Student> findStudentsWithoutPhoneNum();
	
	
	
}
