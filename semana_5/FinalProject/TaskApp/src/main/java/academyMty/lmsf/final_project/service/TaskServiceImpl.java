package academyMty.lmsf.final_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academyMty.lmsf.final_project.repository.TaskRepository;
import academyMty.lmsf.final_project.model.Task;
import jakarta.persistence.EntityNotFoundException;
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
	public Task getTaskById(int id) {
		Task retrieveTask = taskRepository.findById(id)
				.orElseThrow(
					() -> new EntityNotFoundException("No task of ID #"+id+ " exists in the list....")
						);
				
		
		return retrieveTask;
	}

	@Override
	public long countTasks() {
		return taskRepository.count();
	}

}
