package com.myvet.myvet.dtos.pessoa;

import com.myvet.myvet.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.myvet.myvet.models.Pessoa;

@JsonPropertyOrder({"id", "nome", "cpf", "email", "tipo"})
public class PessoaResponseDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private TipoPessoa tipo;


    public PessoaResponseDTO(){
        
    }

    public PessoaResponseDTO(Pessoa entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.cpf = entity.getCpf();
        this.email = entity.getEmail();
        this.tipo = entity.getTipo();
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

    
}
