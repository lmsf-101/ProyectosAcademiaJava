package academyMty.lmsf.final_project.service;

import java.util.List;

import academyMty.lmsf.final_project.model.User;

public interface UserService {

	User createUser(User user);
	User updateUser(User user);
	void changePassword(User user);
	
	
	User getUserById(long id);
	List<User> getAllUsers();
	
	long countUser();
	
	void deleteUser(long id);
	 

}
