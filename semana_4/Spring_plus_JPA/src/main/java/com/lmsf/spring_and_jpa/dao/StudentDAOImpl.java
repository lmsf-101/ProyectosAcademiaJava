package com.lmsf.spring_and_jpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lmsf.spring_and_jpa.entity.Student;
import com.lmsf.spring_and_jpa.entity.Student.Gender;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

// Repository Implementation
@Repository
public class StudentDAOImpl implements StudentDAO {

	@PersistenceContext
	private EntityManager entityManager;
	

	// Save a new student, or update an existing student's data:
	@Override
	public Student saveStudent(Student newStudent) {
		return entityManager.merge(newStudent);
	}
	
	// Find a student by their ID:
	@Override
	public Student findByID(int id) {
		return entityManager.find(Student.class, id);
	}
	
	// Retrieve the number of students in the database:
	@Override
	public long countNumberOfStudents() {
		Query query = entityManager.createQuery("SELECT COUNT(*) FROM Student");
		
		return (long) query.getSingleResult();
	}

	
	
	// Get all the students in the database:
	@Override
	public List<Student> findAll() {
		
		// JPQL Query:
		TypedQuery<Student> searchQuery =
				entityManager.createQuery("FROM Student", Student.class);
		
		// Retrieve the list of results from the query:
		return searchQuery.getResultList();
	}

	// Retrieve students based on their first and last name:
	@Override
	public List<Student> findStudentsByName(String firstName, String lastName) {
		
		// JPQL Query
		TypedQuery<Student> searchQuery =
				entityManager.createQuery("FROM Student WHERE firstName LIKE :fname AND lastName LIKE :lname", Student.class);
		
		// Change placeholders with the provided arguments:
		searchQuery.setParameter("fname", firstName+"%");
		searchQuery.setParameter("lname", lastName+"%");
		
		// Return the list:
		return searchQuery.getResultList();
	}

	
	// Find the students that don't have a phone number:
	@Override
	public List<Student> findStudentsWithoutPhoneNum() {
		TypedQuery<Student> searchQuery =
				entityManager.createQuery("FROM Student WHERE phoneNumber IS NULL", Student.class);
		
		return searchQuery.getResultList();
	}

	// Get the list of students of an specific gender:
	@Override
	public List<Student> findStudentsByGender(Gender gender) {
		TypedQuery<Student> searchQuery =
				entityManager.createQuery("FROM Student WHERE gender = :gender", Student.class);
		
		searchQuery.setParameter("gender", gender);
		
		return searchQuery.getResultList();
	}

	// Delete a student from the database given their ID:
	@Override
	public void deleteStudent(int id) {
		Student studentToRemove = findByID(id);
		
		entityManager.remove(studentToRemove);
	}

}
