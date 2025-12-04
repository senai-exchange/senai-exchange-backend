package com.senai.devs.senaiexchange.dto.response;

import java.time.LocalDateTime;

public class SearchHistoryResponse {

	private Integer id;
	private Integer userId;
	private String username;
	private String displayName;
	private String queryText;
	private String filters;
	private Integer resultCount;
	private LocalDateTime createdAt;

	// Constructors
	public SearchHistoryResponse() {
	}

	public SearchHistoryResponse(Integer id, Integer userId, String username, String displayName, String queryText,
			String filters, Integer resultCount, LocalDateTime createdAt) {
		this.id = id;
		this.userId = userId;
		this.username = username;
		this.displayName = displayName;
		this.queryText = queryText;
		this.filters = filters;
		this.resultCount = resultCount;
		this.createdAt = createdAt;
	}

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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