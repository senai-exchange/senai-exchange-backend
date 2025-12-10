package com.senai.devs.senaiexchange.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CommentRequest {

	// Attributes
	@NotNull (message = "O comentário precisa estar relacionado à uma publicação")
	private int post_id;
	@NotNull (message = "O comentário precisa estar relacionado a um autor")
	private int author_id;
	@NotBlank (message = "O comentário precisa ter algum conteúdo")
	private String content;
	private LocalDateTime created_at;

	// Constructors
	public CommentRequest(){
	}

	public CommentRequest(int post_id, int author_id, String content, LocalDateTime created_at) {
		this.post_id = post_id;
		this.author_id = author_id;
		this.content = content;
		this.created_at = LocalDateTime.now();
	}

	// Getters
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

	// Setters
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

}
