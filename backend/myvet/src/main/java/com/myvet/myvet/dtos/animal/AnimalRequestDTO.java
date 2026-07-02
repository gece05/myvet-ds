package com.myvet.myvet.dtos.animal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AnimalRequestDTO {

    @NotBlank(message = "O animal precisa ter um nome.")
    @Size(min = 2, message = "O nome deve ter no mínimo 2 caracteres.")
    private String nome;

    @NotNull(message = "O animal precisa ser relacionado com alguma pessoa.")
    private Long pessoaId;

    public AnimalRequestDTO(){

    }

    public AnimalRequestDTO(String nome, Long pessoaId){
        this.nome = nome;
        this.pessoaId = pessoaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

}