package com.lmsf.spring_and_jpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lmsf.spring_and_jpa.entity.Student;
import com.lmsf.spring_and_jpa.entity.Student.Gender;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@PersistenceContext
	@Autowired
	private EntityManager entityManager;
	
	
	
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Student saveStudent(Student newStudent) {
		return entityManager.merge(newStudent);
		
		
	}
	
@Override
	public long countNumberOfStudents() {
		Query query = entityManager.createQuery("SELECT COUNT(*) FROM Student");
		
		return (long) query.getSingleResult();
	}

	@Override
	public Student findByID(int id) {
		return entityManager.find(Student.class, id);
	}
	
	@Override
	public List<Student> findAll() {
		TypedQuery<Student> searchQuery =
				entityManager.createQuery("FROM Student", Student.class);
				
		return searchQuery.getResultList();
	}

	@Override
	public List<Student> retrieveStudentsByName(String firstName, String lastName) {
		TypedQuery<Student> searchQuery =
				entityManager.createQuery("FROM Student WHERE firstName LIKE :fname AND lastName LIKE :lname", Student.class);
		
		searchQuery.setParameter("fname", firstName+"%");
		searchQuery.setParameter("lname", lastName+"%");
		
		return searchQuery.getResultList();
	}

	@Override
	public List<Student> findStudentsWithoutPhoneNum() {
		TypedQuery<Student> searchQuery =
				entityManager.createQuery("FROM Student WHERE phoneNumber IS NULL", Student.class);
		
		return searchQuery.getResultList();
	}

	@Override
	public List<Student> retrieveStudentsByGender(Gender gender) {
		TypedQuery<Student> searchQuery =
				entityManager.createQuery("FROM Student WHERE gender = :gender", Student.class);
		
		searchQuery.setParameter("gender", gender);
		
		return searchQuery.getResultList();
	}

	@Override
	public void deleteStudent(int id) {
		Student studentToRemove = findByID(id);
		
		entityManager.remove(studentToRemove);
	}

}
