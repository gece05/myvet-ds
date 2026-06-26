package com.myvet.myvet.dtos.servico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ServicoRequestDTO {

    @NotNull(message = "O produto precisa ter uma descrição.")
    @NotBlank(message = "O produto precisa ter uma descrição.")
    private String descricao;

    @NotNull(message = "O produto precisa ter um valor.")
    private Double valor;

    public ServicoRequestDTO() {
    }

    public ServicoRequestDTO(String descricao, Double valor) {
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
