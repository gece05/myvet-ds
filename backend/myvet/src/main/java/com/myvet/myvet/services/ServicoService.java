package com.myvet.myvet.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myvet.myvet.dtos.servico.ServicoRequestDTO;
import com.myvet.myvet.dtos.servico.ServicoResponseDTO;
import com.myvet.myvet.exceptions.ResourceNotFoundException;
import com.myvet.myvet.models.Servico;
import com.myvet.myvet.repositories.ServicoRepository;



@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Transactional(readOnly = true)
    public List<ServicoResponseDTO> listar() {
        List<Servico> lista = servicoRepository.findAll();

        return lista.stream().map(ServicoResponseDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ServicoResponseDTO buscarPorId(Long id) {
        Servico entity = servicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Servico não encontrado com ID: " + id));

        return new ServicoResponseDTO(entity);
    }

    @Transactional
    public ServicoResponseDTO inserir(ServicoRequestDTO dto) {
        Servico entity = new Servico();

        entity.setDescricao(dto.getDescricao());
        entity.setValor(dto.getValor());

        entity = servicoRepository.save(entity);

        return new ServicoResponseDTO(entity);
    }

    @Transactional
    public ServicoResponseDTO alterar(Long id, ServicoRequestDTO dto){
        Servico entity = servicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Servico não encontrado com ID: " + id));

        entity.setDescricao(dto.getDescricao());
        entity.setValor(dto.getValor());

        entity = servicoRepository.save(entity);

        return new ServicoResponseDTO(entity);
    }

    @Transactional
    public void excluir(Long id){
        if(!servicoRepository.existsById(id)){
            /*TODO: throw Exception*/
        }

        servicoRepository.deleteById(id);
    }
}
