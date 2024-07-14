package com.airlinebookingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlinebookingsystem.entity.User;
import com.airlinebookingsystem.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User registeruser(User user) {
		return userRepository.save(user);
	}
	
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
