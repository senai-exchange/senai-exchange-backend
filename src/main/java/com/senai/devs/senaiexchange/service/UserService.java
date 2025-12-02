package com.senai.devs.senaiexchange.service;

import com.senai.devs.senaiexchange.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	// Attribute
	private final UserRepository userRepository;

	// Constructor
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
