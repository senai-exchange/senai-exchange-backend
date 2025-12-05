package com.senai.devs.senaiexchange.dto.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.senai.devs.senaiexchange.entity.Post;
import com.senai.devs.senaiexchange.entity.Tag;

public class PostResponse {

    // Attributes
    private int id;
    private String username;
    private String title;
    private String content;
    private boolean status;
    private LocalDateTime published_at;
    private LocalDateTime created_at;
    private List<TagResponse> tags = new ArrayList<>();

    // Constructors
    public PostResponse() {
    }

    public PostResponse(Post post) {
        this.id = post.getId();
        this.username = post.getUser().getUsername();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.status = post.getStatus();
        this.published_at = post.getPublished_at();
        this.created_at = post.getCreated_at();

        if (post.getTags() != null) {
            for (Tag tag : post.getTags()) {
                this.tags.add(new TagResponse(tag));
            }
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public boolean isStatus() {
        return status;
    }

    public LocalDateTime getPublished_at() {
        return published_at;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public List<TagResponse> getTags() {
        return tags;
    }
}