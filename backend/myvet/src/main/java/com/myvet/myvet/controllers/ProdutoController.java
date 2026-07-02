package com.myvet.myvet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myvet.myvet.dtos.produto.ProdutoRequestDTO;
import com.myvet.myvet.dtos.produto.ProdutoResponseDTO;
import com.myvet.myvet.services.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listar() {
        List<ProdutoResponseDTO> lista = produtoService.listar();

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorID(@PathVariable Long id) {
        ProdutoResponseDTO entity = produtoService.buscarPorId(id);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> inserir(@Valid @RequestBody ProdutoRequestDTO dto) {
        ProdutoResponseDTO entity = produtoService.inserir(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> alterar(
            @PathVariable Long id,
            @RequestBody ProdutoRequestDTO dto) {

        ProdutoResponseDTO entity = produtoService.alterar(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        produtoService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
