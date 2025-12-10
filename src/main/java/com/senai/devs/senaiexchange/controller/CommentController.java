package com.senai.devs.senaiexchange.controller;

import com.senai.devs.senaiexchange.dto.request.CommentRequest;
import com.senai.devs.senaiexchange.service.CommentService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

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
	public ResponseEntity<?> listAllComments() {
		return ResponseEntity.ok(commentService.listAllComments());
	}

	@GetMapping (value = "/user/{username}")
	public ResponseEntity<?> listUserComments(@PathVariable String username) {
		return ResponseEntity.ok(commentService.listUserComments(username));
	}

	@PostMapping (value = "/publish")
	public ResponseEntity<?> publishComment(@Valid @RequestBody CommentRequest commentRequest) {
		return ResponseEntity.ok(commentService.publishComment(commentRequest));
	}

	@PutMapping (value = "/edit/{id}")
	public ResponseEntity<?> editComment(@PathVariable int id, @RequestBody CommentRequest editedComment) {
		return ResponseEntity.ok(commentService.editComment(id, editedComment));
	}

	@DeleteMapping (value = "/delete/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable int id) {
		return ResponseEntity.ok(commentService.deleteComment(id));
	}

}
