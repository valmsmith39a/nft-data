package com.example.demo.helloMetaverseController;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

@WebMvcTest
class HelloMetaverseControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void greeting() {
		HelloMetaverse controller = new HelloMetaverse();
		String response = controller.greeting("Hari Seldon");
		assertEquals("Hello, Hari Seldon", response);
	}
	
	@Test
	public void home() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("Hello Metaverse!")));
	}
	
	@Test
	public void getProjects() throws Exception {
		String mockResponse = "[{ id: 1, project_name: Cheddar, project_metrics: { git_commits_total: 899, git_commits_daily_average: 12.5 }}, { id: 2, project_name: Provolone, project_metrics: { git_commits_total: 536, git_commits_daily_ave: 23}}]";
		this.mockMvc.perform(get("/projects")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString(mockResponse)));
	}
}
