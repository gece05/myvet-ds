package com.myvet.myvet.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myvet.myvet.dtos.atendimentoProduto.AtendimentoProdutoRequest;
import com.myvet.myvet.dtos.atendimentoProduto.AtendimentoProdutoResponse;
import com.myvet.myvet.services.AtendimentoProdutoService;

@RestController
@RequestMapping("/atendimentos/produtos")
public class AtendimentoProdutoController {

    private final AtendimentoProdutoService atendimentoProdutoService;

    public AtendimentoProdutoController(AtendimentoProdutoService atendimentoProdutoService) {
        this.atendimentoProdutoService = atendimentoProdutoService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<AtendimentoProdutoResponse> adicionar(
            @RequestBody AtendimentoProdutoRequest dto) {

        AtendimentoProdutoResponse ent = atendimentoProdutoService.inserir(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(ent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<AtendimentoProdutoResponse>> listar(@RequestParam Long atendimentoId) {
        List<AtendimentoProdutoResponse> lista = atendimentoProdutoService.listarPorAtendimento(atendimentoId);

        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(
            @RequestParam Long atendimentoId,
            @PathVariable Long atendimentoProdutoId) {

        atendimentoProdutoService.delete(atendimentoProdutoId);
        return ResponseEntity.noContent().build();
    }
}
