package com.airlinebookingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airlinebookingsystem.entity.User;
import com.airlinebookingsystem.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user){
		User existingUser=userService.findUserByEmail(user.getEmail());
		if(existingUser!=null) {
			return new ResponseEntity<>(null, HttpStatus.CREATED);
		}
		
		User registerUser=userService.registeruser(user);
		return new ResponseEntity<>(registerUser,HttpStatus.CREATED);
	}
}
