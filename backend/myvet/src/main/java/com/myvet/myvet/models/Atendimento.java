package com.myvet.myvet.models;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Atendimento {

    private Long id;
    private LocalDate data;
    // private Situacao situacao;
    private Double valor_servico;


}
