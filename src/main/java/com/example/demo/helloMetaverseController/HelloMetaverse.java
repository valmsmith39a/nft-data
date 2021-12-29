package com.example.demo.helloMetaverseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloMetaverse {
	@RequestMapping(value = "/meta")
	public String getMeta() {
		System.out.println("Metaverse metrics");
		return "{ NFT_metrics: { git_commits_total: 899, git_commits_daily_average: 12.5 }}";
	}
	
	@PostMapping(value = "/api")
	public String helloMeta() {
		System.out.println("Hello Metaverse");
		return "Welcome to the Metaverse";
	}
}
