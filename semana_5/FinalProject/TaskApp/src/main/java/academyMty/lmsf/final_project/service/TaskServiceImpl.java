package academyMty.lmsf.final_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academyMty.lmsf.final_project.model.Task;
import academyMty.lmsf.final_project.model.TaskId;
import academyMty.lmsf.final_project.model.User;
import academyMty.lmsf.final_project.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskRepository taskRepository;
	
//	@Override
//	public List<Task> getTasksByUserId(long userId) {
//		
//		return taskRepository.findByUserId(userId);
//	}
	
	@Override
	public Task findTask(TaskId taskId) {
		
		return taskRepository.findById(taskId).orElseThrow(
				() -> new EntityNotFoundException("Task with ID #" + taskId.getUId() + " does not exist..."));
	}
	
	
//	public Task addTask(Task task) {
//		Task newTask = taskRepository.save(task);
//		
//		return newTask;
//	}
	
//	@Override
//	@Transactional
//	public Task updateTask(Task task) {
//		
//		Task oldTask = getTaskById(task.getID());
//		
//		oldTask.setTitle(task.getTitle());
//		oldTask.setStatus(task.getStatus());
//		
//		return taskRepository.save(oldTask);
//	}

	@Override
	@Transactional
	public void deleteTask(int taskId, long userId) {
		TaskId taskID = new TaskId(taskId, userId);
		
		taskRepository.deleteById(taskID);
	}

	@Override
	public Task addTask(Task task) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public long countTasks(long id) {
//		return taskRepository.countTasksByUserId(id);
//	}
}
