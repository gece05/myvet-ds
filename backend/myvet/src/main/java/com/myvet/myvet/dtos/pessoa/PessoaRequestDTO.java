package com.myvet.myvet.dtos.pessoa;

import jakarta.validation.constraints.NotBlank;
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

    public PessoaRequestDTO() {

    }

    public PessoaRequestDTO(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}