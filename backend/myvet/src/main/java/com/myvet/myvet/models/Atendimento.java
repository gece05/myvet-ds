package com.myvet.myvet.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_atendimento")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_marcada", nullable = false)
    private LocalDate data;

    // private Situacao situacao;

    @Column(nullable = false)
    private Double valorServico;

    @ManyToOne()
    @JoinColumn(name = "servico_id") // TODO: rever com odilon
    private Servico servico;

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValorServico() {
        return valorServico;
    }

    public void setValorServico(Double valorServico) {
        this.valorServico = valorServico;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    

}
