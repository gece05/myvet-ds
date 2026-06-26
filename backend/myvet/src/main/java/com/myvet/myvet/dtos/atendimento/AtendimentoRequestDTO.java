package com.myvet.myvet.dtos.atendimento;

import com.myvet.myvet.enums.TipoSituacao;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class AtendimentoRequestDTO {

    @NotNull(message = "O atendimento precisa de uma data marcada.")
    private LocalDate data;

    @NotNull(message = "O atendimento precisa ter uma situação.")
    private TipoSituacao situacao;

    @NotNull(message = "O atendimento precisa ter um valor.")
    private Double valorServico;

    @NotNull(message = "O atendimento precisa estar relacionado a um serviço.")
    private Long servico_id;

    @NotNull(message = "O atendimento precisa estar relacionado a um animal.")
    private Long animal_id;

    @NotNull(message = "O atendimento precisa estar relacionado a um funcionário.")
    private Long pessoa_funcionario_id;

    public AtendimentoRequestDTO() {
    }

    public AtendimentoRequestDTO(LocalDate data, Double valorServico, TipoSituacao situacao, Long servico_id, Long animal_id, Long pessoa_funcionario_id) {
        this.data = data;
        this.valorServico = valorServico;
        this.situacao = situacao;
        this.servico_id = servico_id;
        this.animal_id = animal_id;
        this.pessoa_funcionario_id = pessoa_funcionario_id;
    }

    public LocalDate getData() {
        return data;
    }

    public TipoSituacao getSituacao() {
        return situacao;
    }

    public Double getValorServico() {
        return valorServico;
    }

    public Long getServico_id() {
        return servico_id;
    }

    public Long getAnimal_id() {
        return animal_id;
    }

    public Long getPessoa_funcionario_id() {
        return pessoa_funcionario_id;
    }
}
