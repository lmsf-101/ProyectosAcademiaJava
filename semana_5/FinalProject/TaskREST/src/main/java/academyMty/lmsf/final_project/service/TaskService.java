package academyMty.lmsf.final_project.service;

import java.util.List;

import academyMty.lmsf.final_project.model.Task;
import academyMty.lmsf.final_project.model.TaskId;

public interface TaskService {
	
	Task addTaskToUser(Task task);
	
	Task getTaskByUser(long userId, int taskId);
	
	List<Task> getTasksOfUser(long userId);
	
	long countTasks(long userId);
	
	Task updateTaskOfUser(Task task);
	
	void deleteTask(TaskId id);
	
} 
