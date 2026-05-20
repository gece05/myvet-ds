package com.myvet.myvet.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myvet.myvet.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long>{
    boolean existsByCpf(String cpf);
    Optional<Pessoa> findByCpf(String cpf);
}
