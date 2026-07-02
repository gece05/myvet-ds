package com.myvet.myvet.dtos.produto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.myvet.myvet.models.Produto;

@JsonPropertyOrder({"id","descricao","valor"})
public class ProdutoResponseDTO {

    private Long id;

    private String descricao;

    private Double valor;

    public ProdutoResponseDTO(){

    }

    public ProdutoResponseDTO(Produto ent){
        this.id = ent.getId();
        this.descricao = ent.getDescricao();
        this.valor = ent.getValor();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }
}
