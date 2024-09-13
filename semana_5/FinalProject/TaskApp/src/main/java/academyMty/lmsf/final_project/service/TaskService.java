package academyMty.lmsf.final_project.service;

import java.util.List;
import java.util.Optional;

import academyMty.lmsf.final_project.model.Task;
import academyMty.lmsf.final_project.model.Task.Status;
import academyMty.lmsf.final_project.model.TaskId;
import academyMty.lmsf.final_project.model.User;

public interface TaskService {
	
	Task addTask(Task task);
//	void removeTaskById(int id);
//	Task getTaskById(int id);
//	List<Task> getTasksByUserId(long userId);
//	Task findTask(int taskId, long userId);
//	long countTasks(long id);
	
	//List<Task> findByUser(User user);
	//Task updateTask(Task task);
	void deleteTask(int taskId, long userId);
	Task findTask(TaskId taskId);
} 
