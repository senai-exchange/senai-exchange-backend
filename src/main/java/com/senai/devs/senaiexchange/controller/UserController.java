package com.senai.devs.senaiexchange.controller;

import com.senai.devs.senaiexchange.service.UserService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping ("/users")
public class UserController {

	// Attribute
	private final UserService userService;

	// Constructor
	public UserController(UserService userService) {
		this.userService = userService;
	}

}
