package com.lmsf.Simple_JPA_App.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lmsf.Simple_JPA_App.entities.Guest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class GuestImplementation implements GuestDAO {
	
	private EntityManager entityManager;
	
	
	public GuestImplementation(EntityManager entityManager) {
		// Set up the main component that is the EntityManager
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void addGuest(Guest guest) {
		entityManager.persist(guest); // <- Simple command to save the guest into the database...
		
	}
	
	@Override
	@Transactional
	public void updateGuest(Guest guest) {
		entityManager.merge(guest); // <- Updates the entity
	}
	
	@Override
	@Transactional
	public void removeGuest(int id) {
		// retrieve the student
        Guest retrievedGuest = entityManager.find(Guest.class, id);
		entityManager.remove(retrievedGuest);
		
	}

	@Override
	public Guest getGuestByID(int id) {
		return entityManager.find(Guest.class, id);

	}
	
	@Override
	public List<Guest> getGuestsByName(String name) {
		TypedQuery<Guest> searchQuery =	entityManager.createQuery(
					"FROM Guest WHERE name LIKE :specificName", Guest.class
					);
		
		searchQuery.setParameter("specificName", "%"+ name + "%");
		
		return searchQuery.getResultList();
	}
	
	@Override
	public List<Guest> getAllGuests() {
		TypedQuery<Guest> searchQuery = entityManager.createQuery(
					"FROM Guest", Guest.class
				);
		
		return searchQuery.getResultList();
	}

}
