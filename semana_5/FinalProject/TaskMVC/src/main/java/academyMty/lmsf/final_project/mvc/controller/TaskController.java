package academyMty.lmsf.final_project.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import academyMty.lmsf.final_project.model.Task;
import academyMty.lmsf.final_project.service.TaskService;

@Controller
@RequestMapping("/list") // Base URL
public class TaskController {

	// Inject the Service layer to interact with the database:
	@Autowired
	private TaskService taskService;
	

	// Retrieve the list of existing tasks beforehand:
	@ModelAttribute
	public void addTasksToModel(Model model) {
		
		List<Task> allTasks = taskService.findAllTasks();
		
		// Add the existing task to the model:
		model.addAttribute("curList", allTasks);
		
		// Add a new Task object to the model, as part of
		// the simple creation form included in the page:
		model.addAttribute("task", new Task());
	}
	
	
	// return the view of list:
	@GetMapping
	public String getList() {
		return "list";
	}
	
	//Get the view for edit a specific task, based on it's id:
	@GetMapping("/task/{id}")
	public String editTask(@PathVariable("id") int id, Model model) {
		
		// Get the existing task by its id:
		Task taskToEdit = taskService.getTaskById(id);
		
		
		// Add the task to the model:
		model.addAttribute("editTask", taskToEdit);
				
		return "edit-task";
	}
	
	// Retrieve the view for deleting an existing task:
	@GetMapping("/task/delete/{id}")
	public String deleteTask(@PathVariable("id") int id,  Model model) {
		
		// Get the task to be deleted:
		Task taskToDelete = taskService.getTaskById(id);
		
		// Add it to the model:
		model.addAttribute("delTask", taskToDelete);
		
		return "delete-task";
		
	}
	
	// Save changes for an existing task:
	@PostMapping("/task/{id}")
	public String saveTaskChanges(@PathVariable("id") int id, @ModelAttribute("editTask") Task editTask) {
		
		taskService.updateTask(editTask);
		
		return "redirect:/list";
	}
	
	
	// Request to confirm the deletion of the task:
	@DeleteMapping("/task/delete/{id}")
	public String confirmTaskDelete(@PathVariable("id") int id) {
		
		taskService.removeTaskById(id);
		
		return "redirect:/list";
	}
	
	// Add a new Task object to the existing list:
	@PostMapping
	public String addNewTask(@ModelAttribute Task task) {
		
		task.setID(0);
		task.setStatus(Task.Status.TODO);
		
		taskService.addTask(task);

		
		return "redirect:/list";
	}
	
	
	@GetMapping("/restricted-access")
	public String restrictAcess() {
		return "restricted-access";
	}
	
}
