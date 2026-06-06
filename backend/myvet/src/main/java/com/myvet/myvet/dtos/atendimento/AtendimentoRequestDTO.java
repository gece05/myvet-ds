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

    @NotNull(message = "O atendimento precisa estar relacionado a um cliente.")
    private Long pessoa_cliente_id;

    @NotNull(message = "O atendimento precisa estar relacionado a um funcionário.")
    private Long pessoa_funcionario_id;

    public AtendimentoRequestDTO() {
    }

    public AtendimentoRequestDTO(LocalDate data, Double valorServico, TipoSituacao situacao, Long servico_id, Long pessoa_cliente_id, Long pessoa_funcionario_id) {
        this.data = data;
        this.valorServico = valorServico;
        this.situacao = situacao;
        this.servico_id = servico_id;
        this.pessoa_cliente_id = pessoa_cliente_id;
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

    public Long getPessoa_cliente_id() {
        return pessoa_cliente_id;
    }

    public Long getPessoa_funcionario_id() {
        return pessoa_funcionario_id;
    }
}
