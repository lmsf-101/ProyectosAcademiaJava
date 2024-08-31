package com.lmsf.Simple_JPA_App;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lmsf.Simple_JPA_App.dao.GuestDAO;
import com.lmsf.Simple_JPA_App.entities.Guest;

/*
 * SPRING BOOT + JPA PROJECT EXAMPLE, APPLYING CRUD OPERATIONS
 * Made by: Luis Miguel Sánchez Flores.
 * 
 */


@SpringBootApplication
public class SimpleJpaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleJpaAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(GuestDAO guestDAO) {
		return runner -> {
			
			// Guest object to test out the CRUD operations:
			Guest testGuest = new Guest("Troy Baker", "troy_bake90@gmail.com", 12, "2024-11-03", "2024-11-07");
			
			// Add the new guest into the database:
			addGuest(guestDAO, testGuest);
			
			// Let's update its room number
			updateGuestRoomNumber(guestDAO, testGuest.getId());
			
			// Now remove it!
			removeGuest(guestDAO, testGuest.getId());
			
			
			// try searching it...
			searchGuest(guestDAO, testGuest.getId());
			
			// What about the first guest...
			searchGuest(guestDAO, 1);
			
			// Search the hotel guests that contain the string "John"
			searchGuestsByName(guestDAO, "John");
			
			// Retrieve all guests of the hotel!
			getAllGuests(guestDAO);
			
			
		};
	}
	
	private void addGuest(GuestDAO guestDAO, Guest guest) {
		System.out.println("\nAdding the new guest to the database.... \n" + guest);
		
		// Add the provided guest onto the database...
		guestDAO.addGuest(guest);
		
		System.out.println("Guest was successfully added!");
		System.out.println("NEW ID : " + guest.getId());
		
	}
	
	private void searchGuest(GuestDAO guestDAO, int id) {
		System.out.println("\nRetrieving guest info by ID "+id+"...");
		
		// Pass the ID argument into the DAO function to retrieve the guest:
		Guest retrievedGuest = guestDAO.getGuestByID(id);
		
		
		// If there is no guest in the table with the specified ID, print out the following message:
		if(retrievedGuest == null)
			System.out.println("No guest with the ID of " + id + " was found in the database...");
		
		// Otherwise, display the retrieved guest
		else
			System.out.println("RETRIEVED GUEST: " + retrievedGuest);
	}
	
	private void getAllGuests(GuestDAO guestDAO) {
		System.out.println("\nRetrieving all guests from the database...");
		
		// Get all the guests from the table:
		List<Guest> retrievedGuests = guestDAO.getAllGuests();
		
		// Print out each guest's info:
		System.out.println("ALL GUESTS :");
		printGuests(retrievedGuests);
	}
	
	private void searchGuestsByName(GuestDAO guestDAO, String name) {
		System.out.println("\nRetrieving all guests that contain the string : "+name+"...");
		
		
		// Get the list of guests that contains the specified name argument:
		List<Guest> retrievedGuests = guestDAO.getGuestsByName(name);
		
		// Display all the guests that met the condition:
		System.out.println("RETRIEVED GUESTS: ");
		printGuests(retrievedGuests);
	}
	
	// Auxiliary function:
	private void printGuests(List<Guest> guestList) {
		guestList.forEach(System.out::println);
	}
	
	private void updateGuestRoomNumber(GuestDAO guestDAO, int id) {
		System.out.println("\nUpdate the room number for guest with ID #"+id+"...");
		
		// Search the guest by ID:
		Guest retrievedGuest = guestDAO.getGuestByID(id);
		
		// Update the guest's room number : 
		retrievedGuest.setRoomNum(999);
		
		// Update the guest in the database:
		guestDAO.updateGuest(retrievedGuest);
		
		System.out.println("UPDATED GUEST :" + retrievedGuest);
		
	}
	
	private void removeGuest(GuestDAO guestDAO, int id) {
		System.out.println("\nRemove the guest with ID #"+id+"...");
		
		// Search the guest by ID:
		Guest retrievedGuest = guestDAO.getGuestByID(id);
		
		// Print out the guest to remove:
		System.out.println("GUEST TO REMOVE : " + retrievedGuest);
		
		// Execute the delete command on the database:
		guestDAO.removeGuest(id);
		
		// Print if the action was successfully performed:
		System.out.println("The guest was successfully deleted.");
		
	}

}
