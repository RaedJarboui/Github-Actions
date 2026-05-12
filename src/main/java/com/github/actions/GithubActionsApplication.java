package com.github.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.actions.entity.User;

import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
public class GithubActionsApplication {
	
	Logger logger = LoggerFactory.getLogger(GithubActionsApplication.class);

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
	
	@PutMapping("/update")
	public void updateUser(@RequestBody User user) {
		logger.info("user id : " +  user.getId() + "user name : " +user.getName());
		
	}
	

}
