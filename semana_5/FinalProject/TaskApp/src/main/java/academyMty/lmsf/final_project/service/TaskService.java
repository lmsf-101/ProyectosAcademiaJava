package academyMty.lmsf.final_project.service;

import java.util.List;

import academyMty.lmsf.final_project.model.Task;

public interface TaskService {
	Task addTask(Task task);
	Task updateTask(Task task);
	void removeTaskById(int id);
	Task getTaskById(int id);
	List<Task> findAllTasks();
	long countTasks();
} 
