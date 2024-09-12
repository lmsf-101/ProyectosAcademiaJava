package academyMty.lmsf.final_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academyMty.lmsf.final_project.model.Task;
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
	
	@Override
	public List<Task> findAllTasks() {
		List<Task> allTasks = taskRepository.findAllOrderByStatus();
		return allTasks;
	}
	
	@Override
	@Transactional
	public Task addTask(Task task) {
		Task newTask = taskRepository.save(task);
		
		return newTask;
	}

	@Override
	@Transactional
	public Task updateTask(Task task) {
		
		Task oldTask = getTaskById(task.getID());
		
		oldTask.setTitle(task.getTitle());
		oldTask.setStatus(task.getStatus());
		
		return taskRepository.save(oldTask);
	}

	@Override
	@Transactional
	public void removeTaskById(int id) {
		taskRepository.deleteById(id);
	}

	@Override
	public Task getTaskById(int id) {
		Task retrieveTask = taskRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Task with ID #"+id+" does not exists..."));
		
		return retrieveTask;
	}

	@Override
	public List<Task> getTaskByTitle(String title) {
		List<Task> matchTasks = taskRepository.getTaskByTitleIgnoreCaseContaining(title);
		
		return matchTasks;
	}

	@Override
	public long countTasks() {
		return taskRepository.count();
	}
	
	@Override
	public List<Task> findByUser(User user) {
		return taskRepository.findByUser(user);
	}

}
