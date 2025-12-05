
package com.senai.devs.senaiexchange.entity;

import jakarta.persistence.*;

@Entity
@Table(name="drafts")
public class Draft{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name ="post_id", nullable = false)
	private int postId;
	@Column(name ="author_id", nullable = false)
	private int authorId;
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content_text;
	@Column(nullable = false, length = 200)
	private String title;
	private boolean is_autosave = false;
	
	public Draft() {
	}

	public Draft(int postId, int authorId, String content_text, String title, boolean is_autosave) {
		this.postId = postId;
		this.authorId = authorId;
		this.content_text = content_text;
		this.title = title;
		this.is_autosave = is_autosave;
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
	};
	
	

}