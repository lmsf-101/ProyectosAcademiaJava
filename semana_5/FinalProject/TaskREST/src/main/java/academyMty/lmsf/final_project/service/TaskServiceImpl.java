package academyMty.lmsf.final_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academyMty.lmsf.final_project.entity.Task;
import academyMty.lmsf.final_project.entity.TaskId;
import academyMty.lmsf.final_project.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

// TASK SESRVICE IMPLEMENTATION

@Service
public class TaskServiceImpl implements TaskService{

	// Automatically inject the TaskRepository onto the service to perform the operations:
	@Autowired
	private TaskRepository taskRepository;

	@Transactional
	@Override
	public Task addTaskToUser(Task task) {
		return taskRepository.save(task); // Use built-in JpaRepository method to save the task object:
	}

	@Override
	public Task getTaskByUser(long userId, int taskId) {
		
		// Find the specific task of a specific user by means of their ID
		// If the task was not found, throw an exception that the entity was not found:
		return taskRepository.findTaskByUser(taskId, userId).orElseThrow(
				
				() -> new EntityNotFoundException("Task of ID #" + taskId + " for User #" + userId + " does not exist...")
				
				);
	}
	
	@Override
	public long countTasks(long userId) {
		return taskRepository.countTasks(userId);
	}

	@Override
	public List<Task> getTasksOfUser(long userId) {
		return taskRepository.findByUser(userId);
	}
	
	@Transactional
	public Task updateTaskOfUser(Task task) {
		
		// Check if the task exists for the specific user:
		Task oldTask = getTaskByUser(task.getUId(), task.getTId());
		
		// If that's the case, then update the title and status of the existing task:
		oldTask.setTitle(task.getTitle());
		oldTask.setStatus(task.getStatus());
		
		// Save the existing task:
		return taskRepository.save(oldTask);
	
	}

	@Transactional
	@Override
	public void deleteTask(TaskId id) {
		taskRepository.deleteById(id);
		
	}
}
