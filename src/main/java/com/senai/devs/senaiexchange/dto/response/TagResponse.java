package com.senai.devs.senaiexchange.dto.response;

import com.senai.devs.senaiexchange.entity.Tag;

public class TagResponse {

    private Long id;
    private String nome;

    public TagResponse(Tag tag) {
        this.id = tag.getId();
        this.nome = tag.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}