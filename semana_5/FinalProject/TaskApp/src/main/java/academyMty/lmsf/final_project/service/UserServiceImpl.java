package academyMty.lmsf.final_project.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academyMty.lmsf.final_project.model.Task;
import academyMty.lmsf.final_project.model.User;
import academyMty.lmsf.final_project.repository.TaskRepository;
import academyMty.lmsf.final_project.repository.UserRepository;
import academyMty.lmsf.final_project.rest.controller.TaskRestController;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		User newUser = userRepository.save(user);
		
		return newUser;
	}

	@Transactional
	@Override
	public User changePassword(long id, String password) {
		
		if (userRepository.existsById(id)) {
			User user = getUserById(id);
			
			user.setPassword(password);
			
			updateUser(user);
			
			return user;
		}
		
		return null;
		
	}
	
	@Transactional
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("No user with ID #"+id+" was found..."));
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public long countUser() {
		return userRepository.count();
	}

	@Transactional
	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}
	
//	
//	@Override
//	public List<Task> getTasksOfUser(long userId) {
//		return taskRepository.findByuId(userId);
//	}
//	
//	@Override
//	public Task getTaskByUser(long userId, int taskId) {
//		return null;		//return taskRepository.findByTaskIdTAndTaskIdU(taskId, userId);
//	}
//	
//	
//	@Override
//	public Task addTaskToUser(long userId, Task task) {
//		User user = getUserById(userId);
//		
//		task.setUser(user);
//		
//		return taskRepository.save(task);
//	}
//	
//	@Override
//	public List<Task> getAllTasks(long id) {
//		User user = getUserById(id);
//		
//		return user.getTasks();
//	}
//	
//	@Override
//	public Task getTask(long userId, int taskId) {
//		User user = getUserById(userId);
//		
//		
//		Task task = user.getTasks().get(taskId);
//		
//		return task;
//	}
//	
//	@Override
//	@Transactional
//	public void addTask(long userId, Task task) {
//		User user = getUserById(userId);
//		
//		user.getTasks().add(task);
//		
//		sortList(user);
//		
//		updateUser(user);
//	}
//	
//	@Override
//	@Transactional
//	public void changeTask(long userId, Task newTask) {
//		User user = getUserById(userId);
//		
//		//Task taskToUpdate = getTask(userId, newTask.getID());
//		
////		int index = user.getTasks().indexOf(taskToUpdate);
//		
//		user.getTasks().set(newTask.getID(), newTask);
//		
//		sortList(user);
//		
//		updateUser(user);		
//		
//		
//	}
//	
//	@Override
//	@Transactional
//	public void deleteTask(long userId, int taskId) {
//		User user = getUserById(userId);
//		//Task taskToDelete = getTask(userId, taskId);
//		
//		user.getTasks().remove(taskId);
//		
//		sortList(user);
//		
//		updateUser(user);
//	}
//	
//	private void sortList(User user) {
//		Collections.sort(user.getTasks());
//	}

}
