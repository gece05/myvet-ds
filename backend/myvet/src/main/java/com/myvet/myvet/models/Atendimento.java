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
    private Double valor_servico;

}
