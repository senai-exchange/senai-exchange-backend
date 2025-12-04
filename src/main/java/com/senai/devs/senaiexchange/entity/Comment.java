package com.senai.devs.senaiexchange.entity;

import com.senai.devs.senaiexchange.entity.User;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "comments")
public class Comment {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private int post_id;
	private int author_id;
	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;
	@Column(nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created_at;

	// Foreign key
	@ManyToOne
	@JoinColumn (name = "author_id")
	private User user;

	// Constructors
	public Comment() {
	}

	public Comment(int post_id, int author_id, String content, LocalDateTime created_at) {
		this.post_id = post_id;
		this.author_id = author_id;
		this.content = content;
		this.created_at = created_at;
	}

	// Getters
	public int getId() {
		return id;
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

	// Setters
	public void setId(int id) {
		this.id = id;
	}

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
