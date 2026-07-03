package com.myvet.myvet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myvet.myvet.dtos.atendimentoProduto.AtendimentoProdutoRequest;
import com.myvet.myvet.dtos.atendimentoProduto.AtendimentoProdutoResponse;
import com.myvet.myvet.services.AtendimentoProdutoService;

@RestController
@RequestMapping("/atendimentos/produtos")
public class AtendimentoProdutoController {

    @Autowired
    private AtendimentoProdutoService atendimentoProdutoService;

    @PostMapping
    public ResponseEntity<AtendimentoProdutoResponse> adicionar(
            @RequestBody AtendimentoProdutoRequest dto) {

        AtendimentoProdutoResponse ent = atendimentoProdutoService.inserir(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(ent);
    }

    @GetMapping()
    public ResponseEntity<List<AtendimentoProdutoResponse>> listar() {
        List<AtendimentoProdutoResponse> lista = atendimentoProdutoService.listarAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<AtendimentoProdutoResponse>> listar(@PathVariable Long id) {
        List<AtendimentoProdutoResponse> lista = atendimentoProdutoService.listarPorAtendimento(id);

        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(
            @PathVariable Long id) {

        atendimentoProdutoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
