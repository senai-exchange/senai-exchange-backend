package com.senai.devs.senaiexchange.dto.request;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PostRequest {
    @NotNull(message = "O autor é obrigatório")
    private int author_id;

    @NotBlank(message = "O título é obrigatório")
    @Size(max = 200, message = "O título deve ter até 200 caracteres")
    private String title;

    @NotBlank(message = "O conteúdo é obrigatório")
    private String content;

    //status e datas são opcionais na criação; status default false no banco
    private Boolean status;
    private LocalDateTime published_at;

    //lista de IDs de tags para associação
    private Set<Long> tag_ids;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getPublished_at() {
        return published_at;
    }

    public void setPublished_at(LocalDateTime published_at) {
        this.published_at = published_at;
    }

    public Set<Long> getTag_ids() {
        return tag_ids;
    }

    public void setTag_ids(Set<Long> tag_ids) {
        this.tag_ids = tag_ids;
    }
}