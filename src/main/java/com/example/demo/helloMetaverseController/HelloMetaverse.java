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
	
	@RequestMapping(value = "/nfts")
	public @ResponseBody String getNFTs() {
		return "[{ id: 1, type: nft, project_name: GCheezyNFTs, profile: { number_of_nfts: 8, date_created: 02/19/2022 }}]";
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
