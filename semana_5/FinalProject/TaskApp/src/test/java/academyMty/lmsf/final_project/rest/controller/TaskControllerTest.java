/*package academyMty.lmsf.final_project.mvc.controller;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;

import academyMty.lmsf.final_project.model.Task;
import academyMty.lmsf.final_project.service.TaskServiceImpl;

@WebMvcTest(TaskController.class)
@AutoConfigureMockMvc(addFilters = false)
class TaskControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TaskServiceImpl taskService;
	
	Task exampleTask;

	@BeforeEach
	void setUp() throws Exception {
		
		exampleTask = new Task(1, "Test 1", Task.Status.TODO);
	}
	
	@Test
	void testListView() throws Exception {
		
		List<Task> exampleTaskList = List.of(
				
				exampleTask,
				new Task(2, "Test 2", Task.Status.DONE),
				new Task(3, "Test 3", Task.Status.TODO)
				);
				
		
		when(taskService.findAllTasks()).thenReturn(exampleTaskList);
		
		mockMvc.perform(get("/list"))
		.andExpect(model().attribute("curList", exampleTaskList))
		.andExpect(view().name("list"))
		.andExpect(status().isOk());
		
	}

	@Test
	void testTaskEdit() throws Exception {
		
		Task newTask = new Task(1, "New task", Task.Status.DONE);
		
		final String URI = "/list/task/{id}";
		
		when(taskService.getTaskById(exampleTask.getID())).thenReturn(exampleTask);
		
		mockMvc.perform(get(URI, exampleTask.getID()))
				.andExpect(view().name("edit-task"))
				.andExpect(model().attributeExists("editTask"))
				.andExpect(status().isOk());
		
		mockMvc.perform(post(URI, newTask.getID())
					.contentType(MediaType.APPLICATION_FORM_URLENCODED)
					.param("ID", String.valueOf(newTask.getID()))
					.param("title", newTask.getTitle())
					.param("status", newTask.getStatus().name()))
					.andExpect(status().isFound());
		
		
		verify(taskService).updateTask(newTask);
		verify(taskService).getTaskById(newTask.getID());
	}
	
	@Test
	void testTaskSave() throws Exception {

		
		mockMvc.perform(post("/list")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("title",  exampleTask.getTitle())
				).
				andExpect(status().isFound())
				.andExpect(redirectedUrl("/list"));
		
		
		verify(taskService).addTask(any(Task.class));
	}
	
	@Test
	void testTaskDelete() throws Exception {
		//Task newTask = new Task(1, "New task", Task.Status.DONE);
		
		final String URI = "/list/task/delete/{id}";
		
		when(taskService.getTaskById(exampleTask.getID())).thenReturn(exampleTask);
		
		mockMvc.perform(get(URI, exampleTask.getID()))
				.andExpect(model().attributeExists("delTask"))
				.andExpect(view().name("delete-task"))
				.andExpect(status().isOk());
		
		verify(taskService).getTaskById(exampleTask.getID());
		
		mockMvc.perform(delete(URI, exampleTask.getID()))
				.andExpect(status().isFound())
				.andExpect(redirectedUrl("/list"));
		
		
		verify(taskService).removeTaskById(exampleTask.getID());
	}

}
*/