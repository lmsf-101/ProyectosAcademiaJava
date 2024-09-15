package academyMty.lmsf.final_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academyMty.lmsf.final_project.model.Task;
import academyMty.lmsf.final_project.model.TaskId;
import academyMty.lmsf.final_project.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService{
	
	//TODO Define CRUD operations for Composite Key

	@Autowired
	private TaskRepository taskRepository;

	@Transactional
	@Override
	public Task addTaskToUser(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Task getTaskByUser(long userId, int taskId) {
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
		
		Task oldTask = getTaskByUser(task.getUId(), task.getTId());
		
		oldTask.setTitle(task.getTitle());
		oldTask.setStatus(task.getStatus());
		
		return taskRepository.save(oldTask);
	
	}

	@Transactional
	@Override
	public void deleteTask(TaskId id) {
		taskRepository.deleteById(id);
		
	}
}
