package com.myvet.myvet.dtos.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutoRequestDTO {

    @NotNull(message = "O produto precisa ter uma descrição.")
    @NotBlank(message = "O produto precisa ter uma descrição.")
    private String descricao;

    @NotNull(message = "O produto precisa ter um valor.")
    private Double valor;

    public ProdutoRequestDTO() {
    }

    public ProdutoRequestDTO(String descricao, Double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }
}
