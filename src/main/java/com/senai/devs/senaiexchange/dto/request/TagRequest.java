package com.senai.devs.senaiexchange.dto.request;

import jakarta.validation.constraints.NotBlank;

public class TagRequest {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}