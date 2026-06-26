package com.myvet.myvet.repositories;

import com.myvet.myvet.models.Atendimento;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
    Optional<Atendimento> findByPessoaFuncionarioId(Long id);
    Optional<Atendimento> findByAnimalId(Long id);
}
