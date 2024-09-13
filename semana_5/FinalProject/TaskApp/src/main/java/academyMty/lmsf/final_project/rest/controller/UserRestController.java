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
import academyMty.lmsf.final_project.service.TaskService;
import academyMty.lmsf.final_project.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user/{user_id}")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/tasks")
	public List<Task> getAllTasks(@PathVariable long userId) {
		return userService.getTasksOfUser(userId);
	}
	
	@GetMapping("/task/{task_id}")
	public Task getTask(@PathVariable("user_id") long userId, @PathVariable("task_id") int taskId) {
		return userService.getTaskByUser(userId, taskId);
	}
	
//	
//	@Autowired
//	private TaskService taskService;
//	
//	@Autowired
//	private UserService userService;
//
//	@GetMapping
//	public User getUserById(@PathVariable("user_id") long id) {
//		User user = userService.getUserById(id);
//		return user;
//	}
//	
//	@GetMapping("/task")
//	public List<Task> getUsersTasks(@PathVariable("user_id") long userId) {
//		
//		User user = userService.getUserById(userId);
//		
//		List<Task> tasks = taskService.findByUser(user);
//
//		return tasks;
//	}
//	
//	@GetMapping("/task/{task_id}")
//	public Task getTask(@PathVariable("user_id") long userId, @PathVariable("task_id") int taskId) {
//		
//		User user = userService.getUserById(userId);
//		
//		Task task = user.getTasks().get(taskId);
//		
//		return taskService.getTaskById(task.getID());
//		
//	}
//	
//	@PostMapping("/task")
//	public Task saveTask(@PathVariable("user_id") long userId, @RequestBody Task task) {
//		
//		User user = userService.getUserById(userId);
//		
//		task.setID(0);
//		task.setUser(user);
//		
//		return taskService.addTask(task);
//		
//	}
//	
//	@PutMapping("/task")
//	public String updateTask(@PathVariable("user_id") long userId, @RequestBody Task newTask) {
//		
//		//User user = userService.getUserById(userId);
////		Map<Integer,Task> tasks = user.getTasks();
////		
////		Task task = tasks.get(newTask.getID());
////		
////		newTask.setID(task.getID());
//		
//		taskService.updateTask(newTask);
//		
//		
//		//userService.changeTask(userId, task);
//		
//		return "Changed task for User #"+userId;
//	}
//	
//	
//	@DeleteMapping("/task/{task_id}")
//	public String deleteTask(@PathVariable("user_id") long userId, @PathVariable("task_id") int taskId) {
//		
//		User user = userService.getUserById(userId);
//		
//		Task task = user.getTasks().get(taskId);
//		
//		if(task != null) {
//			taskService.removeTaskById(task.getID());
//			return "Deleted task of ID #"+taskId+ " for User #"+userId;
//		}
//		
//		return "";
//	}
//	
}
