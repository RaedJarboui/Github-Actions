package com.github.actions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
public class GithubActionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GithubActionsApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello user";
	}
	@GetMapping("/{userId}")
	public String getUserById(@PathVariable String userId) {
		return "hello user : " +  userId;
	}
	

}
