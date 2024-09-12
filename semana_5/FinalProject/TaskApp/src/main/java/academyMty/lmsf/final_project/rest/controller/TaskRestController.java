package academyMty.lmsf.final_project.rest.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academyMty.lmsf.final_project.model.Task;
import academyMty.lmsf.final_project.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskRestController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping()
	public List<Task> getAllTasks() {
		List<Task> allTasks = taskService.findAllTasks();
		return allTasks;
		
		
	}
	
	@PostMapping
	public String addNewTask(@RequestBody Task newTask) {
		
		newTask.setID(0);
		
		Task addedTask = taskService.addTask(newTask);
		
		return "New task added with the ID #" + addedTask.getID();
		
	}
	
	@PutMapping
	public String updateTask(@RequestBody Task task) {
		
		Task updatedTask = taskService.updateTask(task);
		
		return "Updated task of ID #" + updatedTask.getID() + " : \n" + updatedTask;
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteTask(@PathVariable int id) {
		
		Task taskToDel = getTaskById(id);
		
		taskService.removeTaskById(id);
		
		return "Deleted task with ID #"+id+" : \n" + taskToDel;
	}
	
	@GetMapping(params = "size")
	public String getNumTasks() {
		long numTasks = taskService.countTasks();
		
		return "The number of tasks available is : " + numTasks;
	}
	
	@GetMapping("/{id}")
	public Task getTaskById(@PathVariable int id) {
		Task retrievedTask = taskService.getTaskById(id);
		
		
		return retrievedTask;
	}
	
	@GetMapping("/title/{title}")
	public List<Task> getTaskByTitle(@PathVariable String title) {
		List<Task> tasksByTitle = taskService.getTaskByTitle(title);
		
		return tasksByTitle;
	}
	
	
	
}
