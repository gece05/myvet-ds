package com.myvet.myvet.repositories;

import com.myvet.myvet.models.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
}
