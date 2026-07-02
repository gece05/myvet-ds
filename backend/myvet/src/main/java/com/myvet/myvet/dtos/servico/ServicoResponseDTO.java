package com.myvet.myvet.dtos.servico;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.myvet.myvet.models.Servico;

@JsonPropertyOrder({"id", "descricao","valor"})
public class ServicoResponseDTO {

    private Long id;

    private String descricao;

    private Double valor;

    public ServicoResponseDTO(){

    }

    public ServicoResponseDTO(Servico ent){
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
