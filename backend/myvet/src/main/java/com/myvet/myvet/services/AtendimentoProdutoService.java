package com.myvet.myvet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myvet.myvet.dtos.atendimentoProduto.AtendimentoProdutoRequest;
import com.myvet.myvet.dtos.atendimentoProduto.AtendimentoProdutoResponse;
import com.myvet.myvet.exceptions.ResourceNotFoundException;
import com.myvet.myvet.models.Atendimento;
import com.myvet.myvet.models.AtendimentoProduto;
import com.myvet.myvet.models.Produto;
import com.myvet.myvet.repositories.AtendimentoProdutoRepository;
import com.myvet.myvet.repositories.AtendimentoRepository;
import com.myvet.myvet.repositories.ProdutoRepository;

@Service
public class AtendimentoProdutoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private AtendimentoProdutoRepository atendimentoProdutoRepository;

    public List<AtendimentoProdutoResponse> listarPorAtendimento(Long atendimentoId) {
        List<AtendimentoProduto> lista = atendimentoProdutoRepository.findByAtendimentoId(atendimentoId);
        return lista.stream().map(AtendimentoProdutoResponse::new).toList();
    }

    public List<AtendimentoProdutoResponse> listarAll() {
        List<AtendimentoProduto> lista = atendimentoProdutoRepository.findAll();
        return lista.stream().map(AtendimentoProdutoResponse::new).toList();
    }

    @Transactional
    public AtendimentoProdutoResponse inserir(AtendimentoProdutoRequest dto) {
        if (dto.getQuantidade() == null || dto.getQuantidade() <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }

        Atendimento atendimento = atendimentoRepository.findById(dto.getId_atendimento())
                .orElseThrow(() -> new ResourceNotFoundException("Atendimento não encontrado: " + dto.getId_atendimento()));

        Produto produto = produtoRepository.findById(dto.getId_produto())
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado: " + dto.getId_produto()));

        if (produto.getQtd_estoque() < dto.getQuantidade()) {
            throw new IllegalStateException("Estoque insuficiente para o produto: " + produto.getDescricao());
        }

        produto.setQtd_estoque(produto.getQtd_estoque() - dto.getQuantidade());
        produtoRepository.save(produto);

        AtendimentoProduto ent = new AtendimentoProduto();
        ent.setAtendimento(atendimento);
        ent.setProduto(produto);
        ent.setQtd(dto.getQuantidade());
        ent.setValorProduto(produto.getValor());

        ent = atendimentoProdutoRepository.save(ent);

        return new AtendimentoProdutoResponse(ent);
    }

    @Transactional
    public void delete(Long atendimentoProdutoId) {
        AtendimentoProduto atendimentoProduto = atendimentoProdutoRepository.findById(atendimentoProdutoId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Registro não encontrado com ID: " + atendimentoProdutoId));

        Produto produto = atendimentoProduto.getProduto();
        produto.setQtd_estoque(produto.getQtd_estoque() + atendimentoProduto.getQtd());
        produtoRepository.save(produto);

        atendimentoProdutoRepository.delete(atendimentoProduto);
    }
}
