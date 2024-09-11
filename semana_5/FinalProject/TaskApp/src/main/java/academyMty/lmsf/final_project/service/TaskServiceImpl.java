package academyMty.lmsf.final_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academyMty.lmsf.final_project.repository.TaskRepository;
import academyMty.lmsf.final_project.model.Task;
import jakarta.transaction.Transactional;

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
		return taskRepository.save(task);
	}

	@Override
	@Transactional
	public void removeTaskById(int id) {
		taskRepository.deleteById(id);
	}

	@Override
	public Optional<Task> getTaskById(int id) {
		Optional<Task> retrieveTask = taskRepository.findById(id);
		
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

}
