package com.myvet.myvet.dtos.atendimento;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.myvet.myvet.models.Atendimento;

import java.time.LocalDate;

@JsonPropertyOrder({"id","data","valorServico","servicoId","pessoaClienteId","pessoaFuncionarioId"})
public class AtendimentoResponseDTO {

    private Long id;

    private LocalDate data;

    private Double valorServico;

    private Long servicoId;

    private Long pessoaClienteId;

    private Long pessoaFuncionarioId;

    public AtendimentoResponseDTO() {
    }

    public AtendimentoResponseDTO(Atendimento ent) {
        this.id = ent.getId();
        this.data = ent.getData();
        this.valorServico = ent.getValorServico();
        this.servicoId = ent.getServico().getId();
        this.pessoaClienteId = ent.getPessoaCliente().getId();
        this.pessoaFuncionarioId = ent.getPessoaFuncionario().getId();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public Double getValorServico() {
        return valorServico;
    }

    public Long getServicoId() {
        return servicoId;
    }

    public Long getPessoaClienteId() {
        return pessoaClienteId;
    }

    public Long getPessoaFuncionarioId() {
        return pessoaFuncionarioId;
    }
}
