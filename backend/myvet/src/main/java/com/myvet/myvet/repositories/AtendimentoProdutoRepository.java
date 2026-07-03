package com.myvet.myvet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myvet.myvet.models.AtendimentoProduto;

public interface AtendimentoProdutoRepository extends JpaRepository<AtendimentoProduto, Long> {
    List<AtendimentoProduto> findByAtendimentoId(Long atendimentoId);
}
