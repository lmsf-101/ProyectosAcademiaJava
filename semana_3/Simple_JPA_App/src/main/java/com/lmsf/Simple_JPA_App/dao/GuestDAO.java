package com.lmsf.Simple_JPA_App.dao;

import java.util.List;

import com.lmsf.Simple_JPA_App.entities.Guest;

// Data-Access-Object (DAO) to communicate with the database

public interface GuestDAO {
	
	Guest getGuestByID(int id);
	List<Guest> getGuestsByName(String name);
	List<Guest> getAllGuests();
    void addGuest(Guest guest);
    void updateGuest(Guest guest);
    void removeGuest(int id);
}
