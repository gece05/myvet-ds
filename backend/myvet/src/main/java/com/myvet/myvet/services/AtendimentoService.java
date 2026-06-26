package com.myvet.myvet.services;

import com.myvet.myvet.repositories.AnimalRepository;
import com.myvet.myvet.repositories.AtendimentoRepository;
import com.myvet.myvet.repositories.PessoaRepository;
import com.myvet.myvet.repositories.ServicoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myvet.myvet.dtos.atendimento.AtendimentoRequestDTO;
import com.myvet.myvet.dtos.atendimento.AtendimentoResponseDTO;
import com.myvet.myvet.exceptions.ResourceNotFoundException;
import com.myvet.myvet.models.Atendimento;
import com.myvet.myvet.models.Pessoa;
import com.myvet.myvet.models.Servico;
import com.myvet.myvet.models.Animal;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Transactional(readOnly = true)
    public List<AtendimentoResponseDTO> listar(){
        List<Atendimento> lista = atendimentoRepository.findAll();

        return lista.stream().map(AtendimentoResponseDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public AtendimentoResponseDTO buscarPorId(Long id){
        Atendimento atd = atendimentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Atendimento não encontrado com ID: " + id));

        return new AtendimentoResponseDTO(atd);
    }

    @Transactional(readOnly = true)
    public AtendimentoResponseDTO buscarPorFuncionarioId(Long id){
        Atendimento atd = atendimentoRepository.findByPessoaFuncionarioId(id).orElseThrow(() -> new ResourceNotFoundException("Atendimento não encontrado com ID: " + id));

        return new AtendimentoResponseDTO(atd);
    }

    @Transactional(readOnly = true)
    public AtendimentoResponseDTO buscarPorAnimalId(Long id){
        Atendimento atd = atendimentoRepository.findByAnimalId(id).orElseThrow(() -> new ResourceNotFoundException("Atendimento não encontrado com ID: " + id));

        return new AtendimentoResponseDTO(atd);
    }

    @Transactional
    public AtendimentoResponseDTO inserir(AtendimentoRequestDTO dto){
        Pessoa pessoaFuncionario = pessoaRepository.findById(dto.getPessoa_funcionario_id()).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com ID: " + dto.getPessoa_funcionario_id()));
        Animal animal = animalRepository.findById(dto.getAnimal_id()).orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado com ID: " + dto.getAnimal_id()));
        Servico servico = servicoRepository.findById(dto.getServico_id()).orElseThrow(() -> new ResourceNotFoundException("Servico não encontrado com ID: " + dto.getServico_id()));

        Atendimento entity = new Atendimento();

        entity.setData(dto.getData());
        entity.setAnimal(animal);
        entity.setPessoaFuncionario(pessoaFuncionario);
        entity.setServico(servico);
        entity.setSituacao(dto.getSituacao());
        entity.setValorServico(dto.getValorServico());

        entity = atendimentoRepository.save(entity);

        return new AtendimentoResponseDTO(entity);
    }

    @Transactional
    public AtendimentoResponseDTO alterar(Long id, AtendimentoRequestDTO dto){
        Atendimento entity = atendimentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Atendimento não encontrado com ID: " + id));

        Pessoa pessoaFuncionario = pessoaRepository.findById(dto.getPessoa_funcionario_id()).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com ID: " + dto.getPessoa_funcionario_id()));
        Animal animal = animalRepository.findById(dto.getAnimal_id()).orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado com ID: " + dto.getAnimal_id()));
        Servico servico = servicoRepository.findById(dto.getServico_id()).orElseThrow(() -> new ResourceNotFoundException("Servico não encontrado com ID: " + dto.getServico_id()));

        entity.setData(dto.getData());
        entity.setAnimal(animal);
        entity.setPessoaFuncionario(pessoaFuncionario);
        entity.setServico(servico);
        entity.setSituacao(dto.getSituacao());
        entity.setValorServico(dto.getValorServico());

        entity = atendimentoRepository.save(entity);

        return new AtendimentoResponseDTO(entity);
    }

    @Transactional
    public void excluir(Long id){
        if(!atendimentoRepository.existsById(id)){
            /*TODO: throw Exception*/
        }

        atendimentoRepository.deleteById(id);
    }

}
