package com.myvet.myvet.models;

import jakarta.persistence.*;

@Entity
@Table(name="tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Double valor;

    //@Column(nullable = false)
    //private Integer qtd_estoque;


    public Produto() {
    }

    public Produto(Long id, Double valor, String descricao) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
