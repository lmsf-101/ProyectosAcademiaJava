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
import academyMty.lmsf.final_project.model.User;
import academyMty.lmsf.final_project.service.UserService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/user/{user_id}")
public class UserRestController {
	
	@Autowired
	private UserService userService;

	@GetMapping
	public User getUserById(@PathVariable("user_id") long id) {
		User user = userService.getUserById(id);
		return user;
	}
	
//	@GetMapping("/task")
//	public List<Task> getUsersTasks(@PathVariable("user_id") long userId) {
//		
//		List<Task> tasks = userService.getAllTasks(userId);
//		
//		return tasks;
//	}
//	
//	@GetMapping("/task/{task_id}")
//	public Task getTask(@PathVariable("user_id") long userId, @PathVariable("task_id") int taskId) {
//		
//		//User user = getUser(userId);
//		
//		Task task = userService.getTask(userId, taskId).orElseThrow(() -> new EntityNotFoundException("No task with ID #"+taskId+" was found....."));
//		
//		return task;
//		
//	}
//	
//	@PostMapping("/task")
//	public String saveTask(@PathVariable("user_id") long userId, @RequestBody Task task) {
//		
//		userService.addTask(userId, task);
//		
//		return "Added new task to user #"+userId+" : "+task;
//		
//	}
//	
//	@PutMapping("/task")
//	public String updateTask(@PathVariable("user_id") long userId, @RequestBody Task task) {
//		
//		userService.changeTask(userId, task);
//		
//		return "Changed task of ID #"+task.getID()+ " for User #"+userId;
//	}
//	
//	
//	@DeleteMapping("/task/{task_id}")
//	public String deleteTask(@PathVariable("user_id") long userId, @PathVariable("task_id") int taskId) {
//		
//		userService.deleteTask(userId, taskId);
//		
//		return "Deleted task of ID #"+taskId+ " for User #"+userId;
//		
//	}
	
}
