package com.senai.devs.senaiexchange.controller;

import com.senai.devs.senaiexchange.dto.response.CommentResponse;
import com.senai.devs.senaiexchange.service.CommentService;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping (value = "/comments")
public class CommentController {

	// Attribute
	private final CommentService commentService;

	// Constructor
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	// Endpoints
	@GetMapping (value = "/all")
	public List<CommentResponse> listAllComments() {
		return commentService.listAllComments();
	}

	@GetMapping (value = "/user/{username}")
	public List<CommentResponse> listUserComments(@PathVariable String username) {
		return commentService.listUserComments(username);
	}

	@DeleteMapping (value = "/delete/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).
			body(commentService.deleteComment(id));
	}
}
