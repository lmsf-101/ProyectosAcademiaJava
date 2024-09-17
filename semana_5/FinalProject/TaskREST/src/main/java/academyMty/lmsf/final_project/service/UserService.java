package academyMty.lmsf.final_project.service;

import java.util.List;

import academyMty.lmsf.final_project.entity.User;

// USER SERVICE CONTRACT

public interface UserService {

	// CREATE new user
	User createUser(User user);
	
	// UPDATE existing user
	User updateUser(User user);
	
	// UPDATE password of an existing user:
	void changePassword(User user);
	
	// READ user's details based on the ID provided:
	User getUserById(long id);
	
	// READ all the users in the database:
	List<User> getAllUsers();
	
	// READ the number of users in the database:
	long countUser();
	
	// DELETE the user from the database by its ID:
	void deleteUser(long id);
	 

}
