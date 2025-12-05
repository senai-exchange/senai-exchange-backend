package com.senai.devs.senaiexchange.dto.request;

import jakarta.validation.constraints.NotBlank;

public class CommentRequest {

	// Attributes
	@NotBlank (message = "O comentário precisa estar relacionado à uma publicação")
	private int post_id;
	@NotBlank (message = "O comentário precisa estar relacionado a um autor")
	private int author_id;
	@NotBlank (message = "O comentário precisa ter algum conteúdo")
	private String content;

	// Constructors
	public CommentRequest(){
	}

	public CommentRequest(int post_id, int author_id, String content) {
		this.post_id = post_id;
		this.author_id = author_id;
		this.content = content;
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
}
