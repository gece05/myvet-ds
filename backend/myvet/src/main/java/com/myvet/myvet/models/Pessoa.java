package com.myvet.myvet.models;

import com.myvet.myvet.enums.TipoPessoa;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 14, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoPessoa tipo;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String email, TipoPessoa tipo ) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }
}
