package com.senai.devs.senaiexchange.dto.response;

import com.senai.devs.senaiexchange.entity.Comment;

import java.time.LocalDateTime;

public class CommentResponse {

	// Attributes
	private String username;
	private int post_id;
	private int author_id;
	private String content;
	private LocalDateTime created_at;

	// Constructor
	public CommentResponse() {
	}

	public CommentResponse(Comment comment) {
		this.username = comment.getUser().getUsername();
		this.post_id = comment.getPost().getId();
		this.author_id = comment.getUser().getId();
		this.content = comment.getContent();
		this.created_at = comment.getCreated_at();
	}

	// Getters
	public String getUsername() {
		return username;
	}

	public int getPost_id() {
		return post_id;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public String getContent() {
		return content;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}
}
