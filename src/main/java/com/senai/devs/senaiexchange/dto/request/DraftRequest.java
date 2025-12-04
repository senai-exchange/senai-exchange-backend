
package com.senai.devs.senaiexchange.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DraftRequest{
	
	private int post_id;
	@NotBlank (message = "O id do usuário é necessário")
	private int author_id;
	private String content_text;
	@Size(min = 3, max = 200, message = "O titulo pode ter até 200 caracteres.")
	private String title;
	private boolean is_autosave = false;
	
	public DraftRequest() {
	}

	public DraftRequest(int post_id, int author_id,String content_text,String title, boolean is_autosave) {
		this.post_id = post_id;
		this.author_id = author_id;
		this.content_text = content_text;
		this.title = title;
		this.is_autosave = is_autosave;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
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

	public boolean isIs_autosave() {
		return is_autosave;
	}

	public void setIs_autosave(boolean is_autosave) {
		this.is_autosave = is_autosave;
	}
	
	
	
	
	
	
	
	
}