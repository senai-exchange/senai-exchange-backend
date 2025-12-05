package com.senai.devs.senaiexchange.entity;

import com.senai.devs.senaiexchange.entity.User;
import com.senai.devs.senaiexchange.entity.Post;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "comments")
public class Comment {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;
	@Column(nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created_at;

	// Foreign keys
	@ManyToOne
	@JoinColumn (name = "post_id")
	private Post post;

	@ManyToOne
	@JoinColumn (name = "author_id")
	@OnDelete (action = OnDeleteAction.SET_NULL)
	private User user;

	// Constructors
	public Comment() {
	}

	public Comment(Post post, User user, String content, LocalDateTime created_at) {
		this.post = post;
		this.user = user;
		this.content = content;
		this.created_at = created_at;
	}

	// Getters
	public Post getPost() {
		return post;
	}

	public User getUser() {
		return user;
	}

	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	// Setters
	public void setPost(Post post) {
		this.post = post;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
}
