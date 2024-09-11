package academyMty.lmsf.final_project.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import academyMty.lmsf.final_project.mvc.model.TaskList;
import academyMty.lmsf.final_project.mvc.model.TaskOffline;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/list")
@SessionAttributes("tasks")
public class TaskController {
	
	@ModelAttribute(name="tasks")
	public TaskList taskList() {
		return new TaskList();
	}
	
//	@ModelAttribute(name="task")
//	public TaskOffline newTask() {
//		return new TaskOffline();
//	}
	
	@ModelAttribute
	public void addTasksToModel(Model model, @ModelAttribute("tasks") TaskList tasks) {
		//TaskList tl = (TaskList) model.getAttribute("tasks");
		
		if(tasks.getTasks().isEmpty()) {
		
			TaskOffline task1 = new TaskOffline(1, "Test 1", TaskOffline.Status.TODO);
			TaskOffline task2 = new TaskOffline(2, "Test 2", TaskOffline.Status.TODO);
			TaskOffline task3 = new TaskOffline(3, "Test 3", TaskOffline.Status.DONE);
		
		
			tasks.addTask(task1);
			tasks.addTask(task2);
			tasks.addTask(task3);
		}
		
		model.addAttribute("curList", tasks.getTasks());
		model.addAttribute("task", new TaskOffline());
	}
	
	
	
	@GetMapping
	public String getList() {
		return "list";
	}
	
	@PostMapping
	public String addNewTask(@ModelAttribute TaskOffline task,
			 @ModelAttribute("tasks") TaskList tasks, Model model) {
		
		task.setID(tasks.getTasks().size()+1);
		task.setStatus(TaskOffline.Status.TODO);
		tasks.addTask(task);
		
		log.info("Adding the new task : " + task);
		

		
		return "redirect:/list";
	}
}
