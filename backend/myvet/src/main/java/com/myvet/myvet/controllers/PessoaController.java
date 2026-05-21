package com.myvet.myvet.controllers;

import java.util.List;

import com.myvet.myvet.dtos.animal.AnimalResponseDTO;
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

import com.myvet.myvet.dtos.pessoa.PessoaRequestDTO;
import com.myvet.myvet.dtos.pessoa.PessoaResponseDTO;
import com.myvet.myvet.services.PessoaService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> listar() {
        List<PessoaResponseDTO> lista = pessoaService.listar();

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> buscarPorID(@PathVariable Long id) {
        PessoaResponseDTO entity = pessoaService.buscarPorId(id);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @GetMapping("/animais/{id}")
    public ResponseEntity<List<AnimalResponseDTO>> buscarAnimaisPorId(@PathVariable Long id) {
        List<AnimalResponseDTO> entity = pessoaService.buscarAnimais(id);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<PessoaResponseDTO> buscarPorID(@PathVariable String cpf) {
        PessoaResponseDTO entity = pessoaService.buscarPorCpf(cpf);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> inserir(@Valid @RequestBody PessoaRequestDTO dto) {
        PessoaResponseDTO entity = pessoaService.inserir(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> alterar(
            @PathVariable Long id,
            @RequestBody PessoaRequestDTO dto) {

        PessoaResponseDTO entity = pessoaService.alterar(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        pessoaService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
