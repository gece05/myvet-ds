package com.myvet.myvet.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myvet.myvet.models.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
    Optional<List<Atendimento>> findAllByPessoaFuncionarioId(Long id);
    Optional<List<Atendimento>> findAllByAnimalId(Long id);
}
