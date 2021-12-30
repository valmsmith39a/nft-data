package com.example.demo.helloMetaverseController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class HelloMetaverse {
	
	// Test function 
	public String greeting(String name) {
		return String.format("Hello, %s", name); 
	}
	
	@RequestMapping(value = "/")
	public @ResponseBody String home() {
		return "Hello Metaverse!";
	}
	
	@RequestMapping(value = "/projects")
	public String getProjects() {
		return "[{ id: 1, project_name: Cheddar, project_metrics: { git_commits_total: 899, git_commits_daily_average: 12.5 }}, { id: 2, project_name: Provolone, project_metrics: { git_commits_total: 536, git_commits_daily_ave: 23}}]";
	}
	
	@PostMapping(value = "/projects")
	public String createProject(@RequestBody String projectName) {
		String response = String.format("{ id: 2, project_name: %s}", projectName);
		return response;
	}
	
	@RequestMapping(value = "/projects/{id}", method = RequestMethod.PUT)
	public String updateProject(@RequestBody String projectName, @PathVariable String id) {
		return String.format("{ id: %s, project_name: %s, project_metrics: { git_commits_total: 588, git_commits_daily_average: 13}}", id, projectName);
	}
	
	@RequestMapping(value = "projects/{id}", method = RequestMethod.DELETE)
	public String deleteProject(@PathVariable String id) {
		return String.format("{ id: %s, message: delete successful }", id);
	}

	@PostMapping(value = "/api")
	public String helloMeta() {
		System.out.println("Hello Metaverse");
		return "Welcome to the Metaverse";
	}
}
