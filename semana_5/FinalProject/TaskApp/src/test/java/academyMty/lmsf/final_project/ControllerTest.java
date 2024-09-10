package academyMty.lmsf.final_project;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import academyMty.lmsf.final_project.controller.TaskController;

@WebMvcTest(TaskController.class)
public class ControllerTest {
	
	 @Autowired  
	 private MockMvc mockMvc;
	 
	 
	 @Test
	 public void testIndex() throws Exception {
		 mockMvc.perform(get("/"))
		 		.andExpect(status().isOk())
		 		.andExpect(view().name("index"))
		 		.andExpect(content().string(containsString("Hello World")));
	 }
}
