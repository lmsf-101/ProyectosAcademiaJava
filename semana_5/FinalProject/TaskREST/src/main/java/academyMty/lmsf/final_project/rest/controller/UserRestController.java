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

import academyMty.lmsf.final_project.model.User;
import academyMty.lmsf.final_project.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{user_id}")
	public User getUser(@PathVariable("user_id") long id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("/create")
	public String createUser(@RequestBody User newUser) {
		
		newUser.setID(0);
		
		userService.createUser(newUser);
		
		
		return "Created new user : \n"+ newUser;
		
	}
	
	@PutMapping("/{user_id}")
	public String updateUser(@PathVariable("user_id") long id, @RequestBody User user) {
		
		userService.getUserById(id);
		
		user.setID(id);
		
		userService.updateUser(user);
		

		return "Updated user with ID # " + id;
	}
	
	@PatchMapping("/{user_id}/password")
	public String changePassword(@PathVariable("user_id") long id, @RequestBody User user) {
		
		user.setID(id);
		
		if(user.getPassword() != null) {
			userService.changePassword(user);
		
			return "Changed password for user with ID #"+ user.getID();
		}
		
		throw new RuntimeException("Password cannot be empty. Please try again.");
	}
	
	@DeleteMapping("/{user_id}")
	public String deleteUser(@PathVariable("user_id") long id) {
		
		try {
			userService.getUserById(id);
		} catch (EntityNotFoundException e) {
			return "";
		}
		
		userService.deleteUser(id);
		
		return "User with ID # " + id + " was deleted";
	}
}
