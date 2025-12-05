package com.senai.devs.senaiexchange.dto.response;

public class UserResponse {

	// Attributes
	private String username;
	private String display_name;
	private String avatar_url;

	// Constructor
	public UserResponse() {
	}

	public UserResponse(String username, String display_name, String avatar_url) {
		this.username = username;
		this.display_name = display_name;
		this.avatar_url = avatar_url;
	}

	// Getters
	public String getUsername() {
		return username;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public String getAvatar_url() {
		return avatar_url;
	}
}
