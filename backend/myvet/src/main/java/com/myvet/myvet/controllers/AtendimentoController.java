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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myvet.myvet.dtos.atendimento.AtendimentoResponseDTO;
import com.myvet.myvet.dtos.atendimento.AtendimentoRequestDTO;
import com.myvet.myvet.services.AtendimentoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {
    
    @Autowired
    private AtendimentoService atendimentoService;

    @GetMapping
    public ResponseEntity<List<AtendimentoResponseDTO>> listar() {
        List<AtendimentoResponseDTO> lista = atendimentoService.listar();

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoResponseDTO> buscarPorID(@PathVariable Long id) {
        AtendimentoResponseDTO entity = atendimentoService.buscarPorId(id);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @GetMapping("/animal/{id}")
    public ResponseEntity<AtendimentoResponseDTO> buscarPorAnimalId(@PathVariable Long id) {
        AtendimentoResponseDTO entity = atendimentoService.buscarPorAnimalId(id);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @GetMapping("/func/{id}")
    public ResponseEntity<AtendimentoResponseDTO> buscarPorFuncId(@PathVariable Long id) {
        AtendimentoResponseDTO entity = atendimentoService.buscarPorFuncionarioId(id);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @PostMapping
    public ResponseEntity<AtendimentoResponseDTO> inserir(@Valid @RequestBody AtendimentoRequestDTO dto) {
        AtendimentoResponseDTO entity = atendimentoService.inserir(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtendimentoResponseDTO> alterar(
            @PathVariable Long id,
            @RequestBody AtendimentoRequestDTO dto) {

        AtendimentoResponseDTO entity = atendimentoService.alterar(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        atendimentoService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
