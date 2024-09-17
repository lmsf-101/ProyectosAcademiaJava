package academyMty.lmsf.final_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academyMty.lmsf.final_project.entity.User;
import academyMty.lmsf.final_project.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

// CONCRETE IMPLEMENTATION OF THE USER SERVICE

@Service
public class UserServiceImpl implements UserService {

	// Inject the UserRepository onto the service:
	@Autowired
	private UserRepository userRepository;
	
	
	// Method to create a new user in the database:
	@Override
	@Transactional
	public User createUser(User user) {
		User newUser = userRepository.save(user);
		
		return newUser;
	}

	
	// Method to change the user's password:
	@Transactional
	@Override
	public void changePassword(User user) {
		
		// Check if the user exists in the database by its ID:
		User retrievedUser = getUserById(user.getID());
		
		// Replace the user password with the new one.
		retrievedUser.setPassword(user.getPassword());
		
		// Update the user in the database:
		updateUser(retrievedUser);
		
		
	}
	
	// Method to update an existing user:
	@Transactional
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	
	// Retrieve a user from the database through its ID:
	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("No user with ID #"+id+" was found..."));
	}

	// Retrieve all users of the database:
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll(); // <- Example of JpaRepository built-in method
	}

	// Count the # of users in the database:
	@Override
	public long countUser() {
		return userRepository.count();
	}
	
	// Delete the user from the database with its ID:
	@Transactional
	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}
}
