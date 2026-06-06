package com.myvet.myvet.repositories;

import com.myvet.myvet.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
