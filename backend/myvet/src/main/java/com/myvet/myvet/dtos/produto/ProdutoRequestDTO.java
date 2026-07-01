package com.myvet.myvet.dtos.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutoRequestDTO {

    @NotNull(message = "O produto precisa ter um nome.")
    @NotBlank(message = "O produto precisa ter um nome.")
    private String nome;

    @NotNull(message = "O produto precisa ter uma descrição.")
    @NotBlank(message = "O produto precisa ter uma descrição.")
    private String descricao;

    @NotNull(message = "O produto precisa ter um valor.")
    private Double valor;

    @NotNull(message = "O produto precisa ter um valor (mesmo que seja 0)")
    private Integer qtdEstoque;

    public ProdutoRequestDTO() {
    }

    public ProdutoRequestDTO(String nome, String descricao, Double valor, Integer qtd_estoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.qtdEstoque = qtd_estoque;
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

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

}
