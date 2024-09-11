package academyMty.lmsf.final_project.mvc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import academyMty.lmsf.final_project.model.Task;
import academyMty.lmsf.final_project.service.TaskService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/list")
@SessionAttributes("tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	
	@ModelAttribute(name="tasks")
	public List<Task> taskList() {
		return taskService.findAllTasks();
	}

	// @ModelAttribute("tasks") TaskList tasks
	@ModelAttribute
	public void addTasksToModel(Model model) {
		
		List<Task> allTasks = taskService.findAllTasks();
		
//		if(tasks.getTasks().isEmpty()) {
//		
//			TaskOffline task1 = new TaskOffline(1, "Test 1", TaskOffline.Status.TODO);
//			TaskOffline task2 = new TaskOffline(2, "Test 2", TaskOffline.Status.TODO);
//			TaskOffline task3 = new TaskOffline(3, "Test 3", TaskOffline.Status.DONE);
//		
//		
//			tasks.addTask(task1);
//			tasks.addTask(task2);
//			tasks.addTask(task3);
//		}
		
		model.addAttribute("curList", allTasks);
		model.addAttribute("task", new Task());
	}
	
	
	
	@GetMapping
	public String getList() {
		return "list";
	}
	
	//@ModelAttribute("tasks") TaskList tasks,
	@GetMapping("/task/{id}")
	public String editTask(@PathVariable("id") int id, Model model) {
		
		Optional<Task> taskToEdit = taskService.getTaskById(id);
		
		taskToEdit.ifPresentOrElse(
				(t) -> model.addAttribute("editTask", t), 
				
				() -> {throw new RuntimeException("Nonexistent task for ID #"+id);});

		
		return "edit-task";
	}
	
	
	@PostMapping("/task/{id}")
	public String saveTaskChanges(@PathVariable("id") int id, @ModelAttribute("editTask") Task editTask) {
		
		log.info("Changing to new task : " + editTask);
		
		taskService.updateTask(editTask);
		
		showList();
		
		return "redirect:/list";
	}
	
	
	
	@GetMapping("/task/delete/{id}")
	public String deleteTask(@PathVariable("id") int id,  Model model) {
		Optional<Task> taskToDelete = taskService.getTaskById(id);
		
		if(taskToDelete.isPresent()) {
			model.addAttribute("delTask", taskToDelete.get());
			return "delete-task";
		} else {
			return "redirect:/list";
		}

	}
	
	@DeleteMapping("/task/delete/{id}")
	public String confirmTaskDelete(@PathVariable("id") int id) {
		
		log.info("Deleting task with ID # " + id);
		
		taskService.removeTaskById(id);
		
		showList();
		
		return "redirect:/list";
	}
	
	// @ModelAttribute("tasks") TaskList tasks
	@PostMapping
	public String addNewTask(@ModelAttribute Task task) {
		
		log.info("Adding the new task : " + task);
		task.setID(0);
		task.setStatus(Task.Status.TODO);
		//tasks.addTask(task);
		
		taskService.addTask(task);
		
		
		showList();

		
		return "redirect:/list";
	}
	
	private void showList() {
		log.info("\nNew TaskList : " + taskService.findAllTasks().toString() + "\n");
	}
}
