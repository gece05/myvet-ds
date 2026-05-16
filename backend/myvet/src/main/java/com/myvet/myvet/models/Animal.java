package com.myvet.myvet.models;

import jakarta.persistence.Entity;

@Entity
public class Animal {

    private Long id;
    private String nome;

    private Pessoa pessoa; // TODO: Long pessoaID ou Pessoa?

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
