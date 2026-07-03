package com.myvet.myvet.dtos.atendimentoProduto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.myvet.myvet.models.AtendimentoProduto;

@JsonPropertyOrder({"id", "quantidade", "valor_produto","id_atendimento","id_produto"})
public class AtendimentoProdutoResponse {
    private Long id;

    private Integer quantidade;

    private Double valor_produto;

    private Long id_atendimento;

    private Long id_produto;

    public AtendimentoProdutoResponse(AtendimentoProduto ent){
        this.id = ent.getId();
        this.quantidade = ent.getQtd();
        this.valor_produto = ent.getValorProduto();
        this.id_atendimento = ent.getAtendimento().getId();
        this.id_produto = ent.getProduto().getId();
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getValor_produto() {
        return valor_produto;
    }

    public Long getId_atendimento() {
        return id_atendimento;
    }

    public Long getId_produto() {
        return id_produto;
    }

    
}
