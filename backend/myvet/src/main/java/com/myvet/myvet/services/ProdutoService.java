package com.myvet.myvet.services;

import com.myvet.myvet.dtos.produto.ProdutoRequestDTO;
import com.myvet.myvet.dtos.produto.ProdutoResponseDTO;
import com.myvet.myvet.models.Produto;
import com.myvet.myvet.repositories.PessoaRepository;
import com.myvet.myvet.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public List<ProdutoResponseDTO> listar(){
        List<Produto> lista = produtoRepository.findAll();

        return lista.stream().map(ProdutoResponseDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ProdutoResponseDTO buscarPorId(Long id){
        Produto ent = produtoRepository.findById(id).orElseThrow();

        return new ProdutoResponseDTO(ent);
    }

    @Transactional
    public ProdutoResponseDTO inserir(ProdutoRequestDTO dto){
        Produto entity = new Produto();

        entity.setValor(dto.getValor());
        entity.setDescricao(dto.getDescricao());

        entity = produtoRepository.save(entity);

        return new ProdutoResponseDTO(entity);
    }

    public ProdutoResponseDTO alterar(Long id, ProdutoRequestDTO dto){
        Produto entity = produtoRepository.findById(id).orElseThrow();

        entity.setValor(dto.getValor());
        entity.setDescricao(dto.getDescricao());

        entity = produtoRepository.save(entity);

        return new ProdutoResponseDTO(entity);
    }

    @Transactional
    public void excluir(Long id){
        produtoRepository.deleteById(id);
    }
}
