package com.myvet.myvet.repositories;

import com.myvet.myvet.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
