package com.myvet.myvet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myvet.myvet.dtos.pessoa.PessoaRequestDTO;
import com.myvet.myvet.dtos.pessoa.PessoaResponseDTO;
import com.myvet.myvet.exceptions.DatabaseException;
import com.myvet.myvet.models.Pessoa;
import com.myvet.myvet.repositories.PessoaRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional(readOnly = true)
    public List<PessoaResponseDTO> listar(){
        return pessoaRepository.findAll().stream().map(PessoaResponseDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public PessoaResponseDTO buscarPorId(Long id){
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(/* TODO: Exception */);

        return new PessoaResponseDTO(pessoa);
    }

    @Transactional(readOnly = true)
    public PessoaResponseDTO buscarPorCpf(String cpf){
        Pessoa pessoa = pessoaRepository.findByCpf(cpf).orElseThrow(/* TODO: Exception */);

        return new PessoaResponseDTO(pessoa);
    }

    @Transactional
    public PessoaResponseDTO inserir(PessoaRequestDTO dto){
        if(pessoaRepository.existsByCpf(dto.getCpf())){
            throw new DatabaseException("Já existe uma pessoa com este CPF. CPF: " + dto.getCpf()); 
        }

        Pessoa entity = new Pessoa();

        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());

        entity = pessoaRepository.save(entity);

        return new PessoaResponseDTO(entity);
    }

    @Transactional
    public PessoaResponseDTO alterar(Long id, PessoaRequestDTO dto){
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(/*TODO: Exception */);

        pessoa.setNome(dto.getNome());
        pessoa.setCpf(dto.getCpf());
        pessoa.setEmail(dto.getEmail());

        pessoa = pessoaRepository.save(pessoa);

        return new PessoaResponseDTO(pessoa);        
    }

    @Transactional
    public void excluir(Long id){
        if(!pessoaRepository.existsById(id)){
            /* throw Exception */
        }

        pessoaRepository.deleteById(id);
    }
}
