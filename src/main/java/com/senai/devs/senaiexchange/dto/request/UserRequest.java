package com.senai.devs.senaiexchange.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequest {

	// Attributes
	@NotBlank (message = "Você tem que digitar um username")
	@Size(min = 3, max = 30, message = "O username deve ter entre 3 e 30 caracteres")
	private String username;
	@NotNull (message = "O nome de exibição não pode ser nulo")
	@Size(max = 100, message = "O nome de exibição deve ter até 100 caracteres")
	private String display_name;
	private String avatar_url;

	// Constructors
	public UserRequest(){
	}

	public UserRequest(String username, String display_name, String avatar_url) {
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

	// Setters
	public void setUsername(String username) {
		this.username = username;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}
}
