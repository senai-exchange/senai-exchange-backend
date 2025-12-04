package com.senai.devs.senaiexchange.service;

import com.senai.devs.senaiexchange.repository.UserRepository;
import com.senai.devs.senaiexchange.entity.User;
import com.senai.devs.senaiexchange.dto.response.UserSummaryResponse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	// Attribute
	private final UserRepository userRepository;

	// Constructor
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// List all stored users by ID and username
	public List<UserSummaryResponse> listAllUsers() {
		List<User> userList = userRepository.findAll();
		List<UserSummaryResponse> userSummaryList = new ArrayList<>();

		for (User user : userList) {
			userSummaryList.add(new UserSummaryResponse(user));
		}
		return userSummaryList;
	}
}
