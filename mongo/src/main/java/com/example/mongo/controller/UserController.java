package com.example.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.User;
import com.example.mongo.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		return userRepo.findAll();
		
	}

}
