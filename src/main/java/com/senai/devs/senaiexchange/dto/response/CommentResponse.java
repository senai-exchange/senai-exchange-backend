package com.senai.devs.senaiexchange.dto.response;

import com.senai.devs.senaiexchange.entity.Comment;

import java.time.LocalDateTime;

public class CommentResponse {

	// Attributes
	private String content;
	private LocalDateTime created_at;

	// Constructor
	public CommentResponse() {
	}

	public CommentResponse(Comment comment) {
		this.content = comment.getContent();
		this.created_at = comment.getCreated_at();
	}

	// Getters
	public String getContent() {
		return content;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}
}
