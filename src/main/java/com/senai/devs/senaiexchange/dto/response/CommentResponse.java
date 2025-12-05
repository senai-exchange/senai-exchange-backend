package com.senai.devs.senaiexchange.dto.response;

import com.senai.devs.senaiexchange.entity.Comment;

import java.time.LocalDateTime;

public class CommentResponse {

	// Attributes
	private int post_id;
	private String content;
	private LocalDateTime created_at;

	// Constructor
	public CommentResponse() {
	}

	public CommentResponse(Comment comment) {
		this.post_id = comment.getPost_id();
		this.content = comment.getContent();
		this.created_at = comment.getCreated_at();
	}

	// Getters
	public int getPost_id() {
		return post_id;
	}

	public String getContent() {
		return content;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}
}
