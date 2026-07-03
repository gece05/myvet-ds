package com.myvet.myvet.dtos.pessoa;

import com.myvet.myvet.enums.TipoPessoa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PessoaRequestDTO {

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 4, message = "Nome deve ter no mínimo 4 caracteres.")
    private String nome;

    @NotBlank(message = "O campo 'cpf' é obrigatório.")
    @Size(min = 11, max = 14, message = "O CPF deve ter entre 11 e 14 caracteres.")
    private String cpf;

    @NotBlank(message = "O email é obrigatório.")
    private String email;

    @NotNull(message = "O tipo da pessoa é obrigatório.")
    private TipoPessoa tipo;
    

    public PessoaRequestDTO() {

    }

    public PessoaRequestDTO(String nome, String cpf, String email, TipoPessoa tipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.tipo = tipo;
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