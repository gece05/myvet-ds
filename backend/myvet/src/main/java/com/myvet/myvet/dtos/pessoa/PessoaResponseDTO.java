package com.myvet.myvet.dtos.pessoa;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.myvet.myvet.models.Pessoa;

@JsonPropertyOrder({"id", "nome", "cpf", "email"})
public class PessoaResponseDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;

    public PessoaResponseDTO(){
        
    }

    public PessoaResponseDTO(Pessoa entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.cpf = entity.getCpf();
        this.email = entity.getEmail();
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

    
}
