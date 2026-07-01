package com.myvet.myvet.dtos.produto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.myvet.myvet.models.Produto;

@JsonPropertyOrder({"id", "nome", "descricao","valor", "qtd_estoque"})
public class ProdutoResponseDTO {

    private Long id;

    private String nome;

    private String descricao;

    private Double valor;

    private Integer qtd_estoque;

    public ProdutoResponseDTO(){

    }

    public ProdutoResponseDTO(Produto ent){
        this.id = ent.getId();
        this.nome = ent.getNome();
        this.descricao = ent.getDescricao();
        this.valor = ent.getValor();
        this.qtd_estoque = ent.getQtd_estoque();
    }

    public Long getId() {
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getQtd_estoque() {
        return qtd_estoque;
    }

}
