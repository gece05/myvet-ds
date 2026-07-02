package com.myvet.myvet.repositories;

import com.myvet.myvet.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal,Long> {
   List<Animal> findAllByPessoaId(Long id);

}
