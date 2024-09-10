package academyMty.lmsf.final_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import academyMty.lmsf.final_project.model.Task;
import academyMty.lmsf.final_project.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/all")
	public List<Task> getAllTasks() {
		List<Task> allTasks = taskService.findAllTasks();
		
		return allTasks;
	}
	
	
	
}
