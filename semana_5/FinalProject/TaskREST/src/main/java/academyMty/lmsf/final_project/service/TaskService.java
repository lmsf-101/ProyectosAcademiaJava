package academyMty.lmsf.final_project.service;

import java.util.List;

import academyMty.lmsf.final_project.entity.Task;
import academyMty.lmsf.final_project.entity.TaskId;

//TASK SERVICE CONTRACT

public interface TaskService {
	
	// CREATE a new task for a specific user:
	Task addTaskToUser(Task task);
	
	// READ a specific task, from a specific user:
	Task getTaskByUser(long userId, int taskId);
	
	// READ the list of tasks from a particular user:
	List<Task> getTasksOfUser(long userId);
	
	// READ the number of tasks available for a user:
	long countTasks(long userId);
	
	// UPDATE a task details for a specific user:
	Task updateTaskOfUser(Task task);
	
	// DELETE a specific task based on its composite key (Task ID and User ID):
	void deleteTask(TaskId id);
	
} 
