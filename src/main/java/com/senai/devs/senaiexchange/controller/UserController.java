package com.senai.devs.senaiexchange.controller;

import com.senai.devs.senaiexchange.service.UserService;
import com.senai.devs.senaiexchange.dto.response.UserSummaryResponse;
import com.senai.devs.senaiexchange.dto.response.UserResponse;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping ("/users")
public class UserController {

	// Attribute
	private final UserService userService;

	// Constructor
	public UserController(UserService userService) {
		this.userService = userService;
	}

	// Endpoints
	@GetMapping (value = "/all")
	public List<UserSummaryResponse> listAllUsers() {
		return userService.listAllUsers();
	}

	@GetMapping (value = "/{username}")
	public Optional<UserResponse> listUserByUsername(@PathVariable String username) {
		return userService.listUserByUsername(username);
	}

	@DeleteMapping (value = "/delete/{username}")
	public ResponseEntity<?> deleteUser(@PathVariable String username) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).
			body(userService.deleteUser(username));
	}

}
