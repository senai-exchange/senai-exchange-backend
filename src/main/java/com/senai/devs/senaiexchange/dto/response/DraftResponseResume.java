package com.senai.devs.senaiexchange.dto.response;

import com.senai.devs.senaiexchange.entity.Draft;

public class DraftResponseResume {

    private int id;
    private int authorId;
    private String title;

    public DraftResponseResume(Draft draft) {
        this.id = draft.getId();
        this.authorId = draft.getAuthorId();
        this.title = draft.getTitle();
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


	

	