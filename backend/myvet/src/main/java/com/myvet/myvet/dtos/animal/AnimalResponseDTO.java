package com.myvet.myvet.dtos.animal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.myvet.myvet.models.Animal;

@JsonPropertyOrder({"id","nome","pessoaId"})
public class AnimalResponseDTO{
    private Long id;
    private String nome;
    private Long pessoaId;

    public AnimalResponseDTO(){

    }

    public AnimalResponseDTO(Animal entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.pessoaId = entity.getPessoa().getId();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getPessoaId() {
        return pessoaId;
    }  
}
