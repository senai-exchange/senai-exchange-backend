package com.senai.devs.senaiexchange.controller;

import com.senai.devs.senaiexchange.service.UserService;
import com.senai.devs.senaiexchange.dto.response.UserSummaryResponse;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

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
}
