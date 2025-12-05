package com.senai.devs.senaiexchange.controller;

import com.senai.devs.senaiexchange.service.UserService;
import com.senai.devs.senaiexchange.dto.response.UserSummaryResponse;
import com.senai.devs.senaiexchange.dto.response.UserResponse;
import com.senai.devs.senaiexchange.dto.request.UserRequest;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

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

	@GetMapping (value = "/find/{username}")
	public Optional<UserResponse> listUserByUsername(@PathVariable String username) {
		return userService.listUserByUsername(username);
	}

	@PostMapping (value = "/signup")
	public ResponseEntity<?> signUp(@Valid @RequestBody UserRequest userRequest) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).
			body(userService.signUp(userRequest));
	}

	@DeleteMapping (value = "/delete/{username}")
	public ResponseEntity<?> deleteUser(@PathVariable String username) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).
			body(userService.deleteUser(username));
	}

}
