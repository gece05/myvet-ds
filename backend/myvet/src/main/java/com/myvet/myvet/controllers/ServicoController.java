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

import com.myvet.myvet.dtos.servico.ServicoRequestDTO;
import com.myvet.myvet.dtos.servico.ServicoResponseDTO;
import com.myvet.myvet.services.ServicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/servicos")
public class ServicoController {
        
    @Autowired
    private ServicoService ServicoService;

    @GetMapping
    public ResponseEntity<List<ServicoResponseDTO>> listar() {
        List<ServicoResponseDTO> lista = ServicoService.listar();

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> buscarPorID(@PathVariable Long id) {
        ServicoResponseDTO entity = ServicoService.buscarPorId(id);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @PostMapping
    public ResponseEntity<ServicoResponseDTO> inserir(@Valid @RequestBody ServicoRequestDTO dto) {
        ServicoResponseDTO entity = ServicoService.inserir(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> alterar(
            @PathVariable Long id,
            @RequestBody ServicoRequestDTO dto) {

        ServicoResponseDTO entity = ServicoService.alterar(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        ServicoService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
