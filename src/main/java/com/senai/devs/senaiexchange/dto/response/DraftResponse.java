
package com.senai.devs.senaiexchange.dto.response;

import com.senai.devs.senaiexchange.entity.Draft;

public class DraftResponse{
	
	private int id;
	private int postId;
	private int authorId;
	private String content_text;
	private String title;
	private boolean is_autosave = false;
	
	public DraftResponse() {
	}

	public DraftResponse(Draft draft) {
		this.id = draft.getId();
		this.postId = draft.getPostId();
		this.authorId = draft.getAuthorId();
		this.content_text = draft.getContent_text();
		this.title = draft.getTitle();
		this.is_autosave = draft.getIs_autosave();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
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