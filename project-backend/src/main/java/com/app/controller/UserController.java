package com.app.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.User;
import com.app.services.IUserService;


@RestController
@RequestMapping("/api")
public class UserController {
	
	private IUserService userService;
	
	public UserController(IUserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser = userService.createUser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@PutMapping("/{uId}")
	public ResponseEntity<User> updateUser(@PathVariable Long uId, @RequestBody User user){
		User updateUser = userService.updateUser(uId, user);
		return new ResponseEntity<User>(updateUser, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{uId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long uId){
			userService.deleteUser(uId);
		return new ResponseEntity<>("User Deleted !!", HttpStatus.CREATED);
	}
	
	
	
	
	
	

}
