package com.myvet.myvet.dtos.atendimento;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.myvet.myvet.models.Atendimento;

@JsonPropertyOrder({"id","data","valorServico","servicoId", "descricaoServico","animalId", "nomeAnimal","pessoaFuncionarioId", "nomeFuncionario"})
public class AtendimentoResponseDTO {

    private Long id;

    private LocalDate data;

    private Double valorServico;

    private Long servicoId;

    private String descricaoServico;

    private Long animalId;

    private String nomeAnimal;

    private Long pessoaFuncionarioId;

    private String nomeFuncionario;

    public AtendimentoResponseDTO() {
    }

    public AtendimentoResponseDTO(Atendimento ent) {
        this.id = ent.getId();
        this.data = ent.getData();
        this.valorServico = ent.getValorServico();
        this.servicoId = ent.getServico().getId();
        this.descricaoServico = ent.getServico().getDescricao();
        this.animalId = ent.getAnimal().getId();
        this.nomeAnimal = ent.getAnimal().getNome();
        this.pessoaFuncionarioId = ent.getPessoaFuncionario().getId();
        this.nomeFuncionario = ent.getPessoaFuncionario().getNome();
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

    public Long getAnimalId() {
        return animalId;
    }

    public Long getPessoaFuncionarioId() {
        return pessoaFuncionarioId;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }


}
