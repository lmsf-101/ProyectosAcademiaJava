package academyMty.lmsf.final_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academyMty.lmsf.final_project.model.Task;
import academyMty.lmsf.final_project.model.User;
import academyMty.lmsf.final_project.repository.TaskRepository;
import academyMty.lmsf.final_project.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		User newUser = userRepository.save(user);
		
		return newUser;
	}

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

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}
	
	@Override
	public List<Task> getAllTasks(long id) {
		User user = getUserById(id);
		
		return user.getTasks();
	}
	
	@Override
	public Optional<Task> getTask(long userId, int taskId) {
		User user = getUserById(userId);
		
		
		List<Task> taskList = user.getTasks();
		
		for(Task task: taskList) {
			if(task.getID() == taskId)
				return Optional.of(task);
		}
		
		return Optional.empty();
	}
	
	@Override
	public void addTask(long userId, Task task) {
		User user = getUserById(userId);
		
		user.getTasks().add(task);
		
		updateUser(user);
	}
	
	@Override
	public void changeTask(long userId, Task newTask) {
		User user = getUserById(userId);
		Task taskToUpdate = getTask(userId, newTask.getID())
					.orElseThrow(() -> new EntityNotFoundException("No task with ID #"+newTask.getID()+ " exists to update...."));
		
		
		int index = user.getTasks().indexOf(taskToUpdate);
		
		user.getTasks().set(index, newTask);
		
		updateUser(user);		
		
		
	}
	
	@Override
	public void deleteTask(long userId, int taskId) {
		User user = getUserById(userId);
		Optional<Task> taskToDelete = getTask(userId, taskId);
		
		if(taskToDelete.isPresent()) {
			user.getTasks().remove(taskToDelete.get());
		}
		
		updateUser(user);
	}

}
