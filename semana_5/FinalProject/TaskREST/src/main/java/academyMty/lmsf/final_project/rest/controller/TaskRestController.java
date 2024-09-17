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

import academyMty.lmsf.final_project.entity.Task;
import academyMty.lmsf.final_project.entity.TaskId;
import academyMty.lmsf.final_project.entity.User;
import academyMty.lmsf.final_project.service.TaskService;
import academyMty.lmsf.final_project.service.UserService;


//TASK REST CONTROLLER

@RestController
@RequestMapping(path = "/api/user/{user_id}") // In order to access the entry point, a user id must be passed:
public class TaskRestController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	// Get the list of tasks for a specific user:
	@GetMapping("/tasks")     // Use the user_id path variable passed in the entry point:
	public List<Task> getAllTasks(@PathVariable("user_id") long userId) {
		
		return taskService.getTasksOfUser(userId);
	}
	
	// Get the number of tasks of a specific user:
	@GetMapping("/tasks/size")
	public String getNumTasks(@PathVariable("user_id") long userId) {
		long size = taskService.countTasks(userId);
				
		return "Number of tasks for User #"+userId + " : " + size;
	}
	
	// Get a specific task, for a specific user:
	@GetMapping("/task/{task_id}")
	public Task getTask(@PathVariable("user_id") long userId, @PathVariable("task_id") int taskId) {
		
		// Pass both the user ID and task ID of the path variables to retrieve the individual task:
		return taskService.getTaskByUser(userId, taskId);
	}
	
	// Create a new task for a specific user:
	@PostMapping("/task")
	public Task createTask(@PathVariable("user_id") long userId, @RequestBody Task task ) {
		
		// Retrieve the existing user from the database:
		User user = userService.getUserById(userId);
		
		// Get the list of tasks of the user:
		List<Task> tasks = user.getTasks();
		
		// Assign an ID for the new task
		// If the list is empty, assign it 1, if not, assign it as the subsequent ID available:
		int taskId = tasks.isEmpty() ? 1 : tasks.get(tasks.size()-1).getTId() + 1;
		
		// Set up the IDs for the new task
		task.setTId(taskId);
		task.setUId(userId);
		
		// Add it to the database:
		return taskService.addTaskToUser(task);
		

	}
	
	// Change an existing task's details of a specific user, based on the task ID and user ID:
	@PutMapping("/task")
	public Task updateTask(@PathVariable("user_id") long userId, @RequestBody Task task ) {
		
		// Set up the user ID, if it was not passed in the request's body:
		task.setUId(userId);
		
		return taskService.updateTaskOfUser(task);
	}
	
	// Delete a task from the list of a specific user:
	@DeleteMapping("/task/{task_id}")
	public String deleteTask(@PathVariable("user_id") long userId, @PathVariable("task_id") int taskId) {

		// Create the composite key, based on the task ID and user ID:
		TaskId tId = new TaskId(taskId, userId);
		
		taskService.deleteTask(tId);
		
		return "Deleted Task #"+taskId+ " from User with ID #"+userId;
	}
	
}
