package com.senai.devs.senaiexchange.entity;

import com.senai.devs.senaiexchange.entity.Post;
import com.senai.devs.senaiexchange.entity.Comment;
import com.senai.devs.senaiexchange.entity.Draft;
import com.senai.devs.senaiexchange.entity.SearchHistory;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "users")
public class User {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 30, unique = true, nullable = false)
	private String username;
	@Column(length = 100, nullable = false)
	private String display_name;
	@Column(length = 512)
	private String avatar_url;

	// Forward keys
	@OneToMany(mappedBy = "user")
	private List<Post> posts = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<Comment> comments = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<Draft> drafts = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<SearchHistory> searchHistory = new ArrayList<>();

	// Constructors
	public User() {
	}

	public User(String username, String display_name, String avatar_url) {
		this.username = username;
		this.display_name = display_name;
		this.avatar_url = avatar_url;
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}
}
