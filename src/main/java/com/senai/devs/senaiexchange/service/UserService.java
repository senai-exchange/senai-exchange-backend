package com.senai.devs.senaiexchange.service;

import com.senai.devs.senaiexchange.repository.UserRepository;
import com.senai.devs.senaiexchange.entity.User;
import com.senai.devs.senaiexchange.dto.response.UserSummaryResponse;
import com.senai.devs.senaiexchange.dto.response.UserResponse;
import com.senai.devs.senaiexchange.dto.request.UserRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	// List user by username
	public Optional<UserResponse> listUserByUsername(String username) {
		User user = userRepository.findByUsername(username);
		UserResponse userResponse = new UserResponse();
		if (user != null) {
			userResponse = new UserResponse(user.getUsername(),
				user.getDisplay_name(), user.getAvatar_url());
		}
		return Optional.of(userResponse);
	}

	// Create new user
	public String signUp(UserRequest userRequest) {
		User newUser = new User(userRequest.getUsername(),
			userRequest.getDisplay_name(), userRequest.getAvatar_url());
		userRepository.save(newUser);
		return String.format("Usuário @%s criado com sucesso!",
			newUser.getUsername());
	}

	// Sign-in
	public String signIn(UserRequest userRequest) {
		User user = userRepository.findByUsername(userRequest.getUsername());
		if (user != null) {
			return String.format("Login efetuado com sucesso! Bem vindo(a) "
				+ "@%s!", user.getUsername());
		} else {
			return "Usuário não encontrado!";
		}
	}

	// Update user information
	public String updateUser(String username, UserRequest updatedUser) {
		User user = userRepository.findByUsername(username);

		if (user != null) {
			user.setDisplay_name(updatedUser.getDisplay_name());
			user.setAvatar_url(updatedUser.getAvatar_url());
			userRepository.save(user);
			return "Usuário atualizado!";
		} else {
			return "Usuário não encontrado!";
		}
	}

	// Delete user by username
	public String deleteUser(String username) {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			userRepository.deleteById(user.getId());
			return String.format("Usuário @%s excluído com sucesso!",
				user.getUsername());
		} else {
			return "Esse usuário não existe!";
		}
	}

}
