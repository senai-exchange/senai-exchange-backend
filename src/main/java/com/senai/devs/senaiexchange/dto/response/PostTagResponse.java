package com.senai.devs.senaiexchange.dto.response;

import com.senai.devs.senaiexchange.entity.PostTag;

public class PostTagResponse {

    private Integer post_id;
    private Long tag_id;
    private String post_title;
    private String tag_name;

    public PostTagResponse() {}

    public PostTagResponse(PostTag pt) {
        this.post_id = pt.getPost().getId();
        this.tag_id = pt.getTag().getId();
        this.post_title = pt.getPost().getTitle();
        this.tag_name = pt.getTag().getName();
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Long getTag_id() {
        return tag_id;
    }

    public void setTag_id(Long tag_id) {
        this.tag_id = tag_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }
}