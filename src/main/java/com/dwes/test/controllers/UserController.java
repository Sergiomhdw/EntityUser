package com.dwes.test.controllers;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dwes.test.entities.User;
import com.dwes.test.entities.UserProfile;
import com.dwes.test.repository.UserRepository;



public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users/{id}/profile")
	public ResponseEntity<UserProfile> findOne(@PathVariable @Min(1) Long id){
		User user = userRepository.findById(id).orElse(null);
		if(user == null) {
			return ResponseEntity.notFound().build();
		}else {
			UserProfile userprofile = user.getUserprofile();
			return ResponseEntity.ok(userprofile);
		}
	}
}

