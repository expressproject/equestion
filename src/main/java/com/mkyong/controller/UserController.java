package com.mkyong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.dto.UserProfileDTO;
import com.mkyong.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping(value = "saveUser", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> addUser(@RequestBody UserProfileDTO userProfile) {

		boolean result = userServiceImpl.addUser(userProfile);
		String message = result ? "user registered successfully"
				: "user registration failed(may be duplicate Id,Enter new Id)";
		return ResponseEntity.ok().body(message);
	}

	@GetMapping(value = "getUsers")
	public ResponseEntity<List<UserProfileDTO>> fetchUsers() {

		List<UserProfileDTO> allUsers = userServiceImpl.fetchAllUsers();

		return ResponseEntity.status(HttpStatus.OK).body(allUsers);
	}

}
