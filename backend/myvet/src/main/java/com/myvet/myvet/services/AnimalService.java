package com.myvet.myvet.services;

import com.myvet.myvet.dtos.animal.AnimalRequestDTO;
import com.myvet.myvet.dtos.animal.AnimalResponseDTO;
import com.myvet.myvet.dtos.pessoa.PessoaResponseDTO;
import com.myvet.myvet.exceptions.DatabaseException;
import com.myvet.myvet.exceptions.ResourceNotFoundException;
import com.myvet.myvet.models.Animal;
import com.myvet.myvet.models.Pessoa;
import com.myvet.myvet.repositories.AnimalRepository;
import com.myvet.myvet.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private PessoaRepository pessoaRepository;


    @Transactional(readOnly = true)
    public List<AnimalResponseDTO> listar() {
        List<Animal> lista = animalRepository.findAll();

        return lista.stream().map(AnimalResponseDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public AnimalResponseDTO buscarPorId(Long id) {
        Animal entity = animalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado com ID: " + id));

        return new AnimalResponseDTO(entity);
    }

    @Transactional(readOnly = true)
    public PessoaResponseDTO buscarDono(Long id) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado com ID: " + id));

        Pessoa dono = pessoaRepository.findById(animal.getPessoa().getId()).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com ID: " + animal.getPessoa().getId()));

        return new PessoaResponseDTO(dono);
    }

    @Transactional
    public AnimalResponseDTO inserir(AnimalRequestDTO dto) {
        Pessoa dono = pessoaRepository.findById(dto.getPessoaId()).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com ID: " + dto.getPessoaId()));
        Animal entity = new Animal();

        entity.setNome(dto.getNome());
        entity.setPessoa(dono);

        entity = animalRepository.save(entity);

        return new AnimalResponseDTO(entity);
    }

    @Transactional
    public AnimalResponseDTO alterar(Long id, AnimalRequestDTO dto){
        Animal entity = animalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado com ID: " + id));
        Pessoa dono = pessoaRepository.findById(dto.getPessoaId()).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com ID: " + dto.getPessoaId()));

        entity.setNome(dto.getNome());
        entity.setPessoa(dono);

        entity = animalRepository.save(entity);

        return new AnimalResponseDTO(entity);
    }

    @Transactional
    public void excluir(Long id){
        if(!animalRepository.existsById(id)){
            /*TODO: throw Exception*/
        }

        animalRepository.deleteById(id);
    }
}
