package academyMty.lmsf.final_project.service;

import java.util.List;
import java.util.Optional;

import academyMty.lmsf.final_project.model.Task;
import academyMty.lmsf.final_project.model.User;

public interface UserService {

	User createUser(User user);
	User updateUser(User user);
	User changePassword(long id, String password);
	
	
	User getUserById(long id);
	List<User> getAllUsers();
	
	long countUser();
	
	void deleteUser(long id);
	
//	Task getTask(long userId, int taskId);
//	void addTask(long userId, Task task);
//	void changeTask(long userId, Task newTask);
//	void deleteTask(long userId, int taskId);
//	List<Task> getAllTasks(long id);
//	
}
