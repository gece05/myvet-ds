package com.myvet.myvet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myvet.myvet.dtos.pessoa.PessoaResponseDTO;
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
}
