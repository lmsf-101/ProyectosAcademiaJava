package academyMty.lmsf.final_project.service;

import java.util.List;
import java.util.Optional;

import academyMty.lmsf.final_project.model.Task;
import academyMty.lmsf.final_project.model.User;

public interface TaskService {
	Task addTask(Task task);
	Task updateTask(Task task);
	void removeTaskById(int id);
	Task getTaskById(int id);
	List<Task> getTaskByTitle(String title);
	List<Task> findAllTasks();
	long countTasks();
	
	List<Task> findByUser(User user);
} 
