package com.senai.devs.senaiexchange.dto.response;

public class DraftResponseResume {
	
	private int post_id;
	private int author_id;
	private String title;

	public DraftResponseResume() {
	}

	public DraftResponseResume(int post_id, int author_id,String title) {
		this.post_id = post_id;
		this.author_id = author_id;
		this.title = title;
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


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
	
	
	
	

