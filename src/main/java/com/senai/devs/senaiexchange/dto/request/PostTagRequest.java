package com.senai.devs.senaiexchange.dto.request;

import jakarta.validation.constraints.NotNull;

public class PostTagRequest {

    @NotNull(message = "O id do post é obrigatório")
    private Integer post_id;

    @NotNull(message = "O id da tag é obrigatório")
    private Long tag_id;

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
}