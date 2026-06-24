package com.myvet.myvet.models;

import com.myvet.myvet.enums.TipoSituacao;
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

    @Column(nullable = false)
    private TipoSituacao situacao;

    @Column(nullable = false)
    private Double valorServico;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;

    @OneToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @OneToOne
    @JoinColumn(name = "pessoa_funcionario_id")
    private Pessoa pessoaFuncionario;

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

    public TipoSituacao getSituacao() {
        return situacao;
    }

    public void setSituacao(TipoSituacao situacao) {
        this.situacao = situacao;
    }

    public Pessoa getPessoaFuncionario() {
        return pessoaFuncionario;
    }

    public void setPessoaFuncionario(Pessoa pessoaFuncionario) {
        this.pessoaFuncionario = pessoaFuncionario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setPessoaCliente(Animal animal) {
        this.animal = animal;
    }
}
