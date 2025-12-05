package com.senai.devs.senaiexchange.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "search_history")
public class SearchHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(name = "query_text", length = 512, nullable = false)
	private String queryText;

	@Column(columnDefinition = "TEXT")
	private String filters;

	@Column(name = "result_count")
	private Integer resultCount;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	// Constructors
	public SearchHistory() {
		this.createdAt = LocalDateTime.now();
	}

	public SearchHistory(User user, String queryText, String filters, Integer resultCount) {
		this.user = user;
		this.queryText = queryText;
		this.filters = filters;
		this.resultCount = resultCount;
		this.createdAt = LocalDateTime.now();
	}

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	public Integer getResultCount() {
		return resultCount;
	}

	public void setResultCount(Integer resultCount) {
		this.resultCount = resultCount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}