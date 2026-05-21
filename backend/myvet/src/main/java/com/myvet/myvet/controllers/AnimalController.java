package com.myvet.myvet.controllers;

import com.myvet.myvet.dtos.animal.AnimalRequestDTO;
import com.myvet.myvet.dtos.animal.AnimalResponseDTO;
import com.myvet.myvet.dtos.pessoa.PessoaRequestDTO;
import com.myvet.myvet.dtos.pessoa.PessoaResponseDTO;
import com.myvet.myvet.repositories.AnimalRepository;
import com.myvet.myvet.services.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<AnimalResponseDTO>> listar() {
        List<AnimalResponseDTO> lista = animalService.listar();

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalResponseDTO> buscarPorID(@PathVariable Long id) {
        AnimalResponseDTO entity = animalService.buscarPorId(id);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @GetMapping("/pessoa/{id}")
    public ResponseEntity<PessoaResponseDTO> buscarDono(@PathVariable Long id){
        PessoaResponseDTO entity = animalService.buscarDono(id);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @PostMapping
    public ResponseEntity<AnimalResponseDTO> inserir(@Valid @RequestBody AnimalRequestDTO dto) {
        AnimalResponseDTO entity = animalService.inserir(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalResponseDTO> alterar(
            @PathVariable Long id,
            @RequestBody AnimalRequestDTO dto) {

        AnimalResponseDTO entity = animalService.alterar(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        animalService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
