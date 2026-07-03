package com.myvet.myvet.dtos.atendimentoProduto;

import jakarta.validation.constraints.NotNull;

public class AtendimentoProdutoRequest {
    
    @NotNull(message = "Precisa ter uma quantidade de produtos.")
    private Integer quantidade;

    @NotNull(message = "Precisa ter o valor do produto.")
    private Double valor_produto;

    @NotNull(message = "Precisa estar relacionado a um atendimento.")
    private Long id_atendimento;

    @NotNull(message = "Precisa estar relacionado a um produto.")
    private Long id_produto;

    public AtendimentoProdutoRequest(){

    }

    public AtendimentoProdutoRequest( Integer quantidade, Double valor_produto, Long id_atendimento, Long id_produto) {
        this.quantidade = quantidade;
        this.valor_produto = valor_produto;
        this.id_atendimento = id_atendimento;
        this.id_produto = id_produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor_produto() {
        return valor_produto;
    }

    public void setValor_produto(Double valor_produto) {
        this.valor_produto = valor_produto;
    }

    public Long getId_atendimento() {
        return id_atendimento;
    }

    public void setId_atendimento(Long id_atendimento) {
        this.id_atendimento = id_atendimento;
    }

    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    

    
}
