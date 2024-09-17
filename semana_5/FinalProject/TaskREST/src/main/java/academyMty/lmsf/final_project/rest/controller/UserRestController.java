package academyMty.lmsf.final_project.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academyMty.lmsf.final_project.entity.User;
import academyMty.lmsf.final_project.service.UserService;
import jakarta.persistence.EntityNotFoundException;

// USER REST CONTROLLER

@RestController // <- Tells Spring that the class should behave as a controller for the REST application:
@RequestMapping("/api/users") // Entry point
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	// Retrieve the list of users of the database:
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	// Get a specific user by its ID:
	@GetMapping("/{user_id}") // Assign the method to take care of the GET requests at this endpoint
	public User getUser(@PathVariable("user_id") long id) {
		return userService.getUserById(id);
	}
	
	// Create a new user into the database, using the HTTP request body data for the instance attributes:
	@PostMapping("/create")
	public String createUser(@RequestBody User newUser) {
		
		// Set the ID as 0, and let the repository handle the automatic assignment of the new user ID:
		newUser.setID(0);
		
		userService.createUser(newUser);
		
		// Show the following message, if successful:
		return "Created new user : \n"+ newUser;
		
	}
	
	// Handler method to update an existing user:
	@PutMapping("/{user_id}")
	public String updateUser(@PathVariable("user_id") long id, @RequestBody User user) {
		
		// Verify that the user exists in the database by its ID:
		userService.getUserById(id);
		
		user.setID(id);
		
		// Update the user with the new data from the request's body:
		userService.updateUser(user);
		

		return "Updated user with ID # " + id;
	}
	
	// PATCH handler method to change an existing user's password:
	@PatchMapping("/{user_id}/password")
	public String changePassword(@PathVariable("user_id") long id, @RequestBody User user) {
		
		user.setID(id);
		
		// If the password is not empty, carry on:
		if(user.getPassword() != null || user.getPassword().isBlank()) {
			
			// Delegate the password change to the service layer:
			userService.changePassword(user);
		
			// Return the following message, if successful:
			return "Changed password for user with ID #"+ user.getID();
		}
		
		// If the password is empty, throw a Runtime error:
		throw new RuntimeException("Password cannot be empty. Please try again.");
	}
	
	// DELETE handler method to remove a user from the database by its ID:
	@DeleteMapping("/{user_id}")
	public String deleteUser(@PathVariable("user_id") long id) {
		
		// Check if the user exists. If not, don't do anything:
		try {
			userService.getUserById(id);
		} catch (EntityNotFoundException e) {return "";}
		
		
		userService.deleteUser(id);
		
		// Return the following message, if successful:
		return "User with ID # " + id + " was deleted";
	}
}
