package com.senai.devs.senaiexchange.dto.response;


public class DraftResponseResume {

    private int id;
    private int authorId;
    private String title;

    public DraftResponseResume(int id, int authorId, String title) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}


	

	