package academyMty.lmsf.final_project.rest.controller;

import java.util.List;


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
import academyMty.lmsf.final_project.model.TaskId;
import academyMty.lmsf.final_project.model.User;
import academyMty.lmsf.final_project.service.TaskService;
import academyMty.lmsf.final_project.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/user/{user_id}", produces = "application/json")
public class TaskRestController {
	
	//TODO Define CRUD operations for Composite Key
	
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/tasks")
	public List<Task> getAllTasks(@PathVariable("user_id") long userId) {
		
		return taskService.getTasksOfUser(userId);
	}
	
	@GetMapping("/tasks/size")
	public String getNumTasks(@PathVariable("user_id") long userId) {
		long size = taskService.countTasks(userId);
				
		return "Number of tasks for User #"+userId + " : " + size;
	}
	
	@GetMapping("/task/{task_id}")
	public Task getTask(@PathVariable("user_id") long userId, @PathVariable("task_id") int taskId) {
		return taskService.getTaskByUser(userId, taskId);
	}
	
	@PostMapping("/task")
	public Task createTask(@PathVariable("user_id") long userId, @RequestBody Task task ) {
		User user = userService.getUserById(userId);
		List<Task> tasks = user.getTasks();
		
		int taskId = tasks.isEmpty() ? 1 : tasks.get(tasks.size()-1).getTId() + 1;
		
		task.setTId(taskId);
		task.setUId(userId);
		
		return taskService.addTaskToUser(task);
		

	}
	
	@PutMapping("/task")
	public Task updateTask(@PathVariable("user_id") long userId, @RequestBody Task task ) {
		
		task.setUId(userId);
		
		return taskService.updateTaskOfUser(task);
	}
	
	@DeleteMapping("/task/{task_id}")
	public String deleteTask(@PathVariable("user_id") long userId, @PathVariable("task_id") int taskId) {
		TaskId tId = new TaskId(taskId, userId);
		
		taskService.deleteTask(tId);
		
		return "Deleted Task #"+taskId+ " from User with ID #"+userId;
	}
	
}
