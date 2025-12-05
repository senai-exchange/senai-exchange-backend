
package com.senai.devs.senaiexchange.dto.request;

import com.senai.devs.senaiexchange.entity.Draft;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DraftRequest{
	
	private int postId;
	@NotNull(message = "Author ID cannot be null")
	private int authorId;
	private String content_text;
	@Size(min = 3, max = 200, message = "The title can have 200 characters.")
	private String title;
	private boolean is_autosave = false;
	
	public DraftRequest() {
	}

	public DraftRequest(Draft draft) {
		this.postId = draft.getPostId();
		this.authorId = draft.getAuthorId();
		this.content_text = draft.getContent_text();
		this.title = draft.getTitle();
		this.is_autosave = draft.getIs_autosave();
	}

	public int getPostId() {
		return postId;
	}

	public void setPost_id(int postId) {
		this.postId = postId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthor_id(int authorId) {
		this.authorId = authorId;
	}

	public String getContent_text() {
		return content_text;
	}

	public void setContent_text(String content_text) {
		this.content_text = content_text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean getIs_autosave() {
		return is_autosave;
	}

	public void setIs_autosave(boolean is_autosave) {
		this.is_autosave = is_autosave;
	}
	
	
	
	
	
	
	
	
}