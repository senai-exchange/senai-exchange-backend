package com.senai.devs.senaiexchange.dto.response;

import com.senai.devs.senaiexchange.entity.User;

public class UserSummaryResponse {

	// Attributes
	private int id;
	private String username;

	// Constructor
	public UserSummaryResponse(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

}
