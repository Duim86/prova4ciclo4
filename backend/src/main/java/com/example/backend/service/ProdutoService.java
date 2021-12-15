package com.example.backend.service;

import com.example.backend.exception.ProdutoNaoEncontradoException;
import com.example.backend.model.Produto;
import com.example.backend.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

  private final ProdutoRepository produtoRepository;
  private final FornecedorService fornecedorService;
  private final TipoProdutoService tipoProdutoService;

  public List<Produto> listar() {
    return produtoRepository.findAll();
  }

  @Transactional
  public Produto adicionar(Produto produto) {
    var fornecedorId = produto.getFornecedor().getId();
    var tipoProdutoId = produto.getTipoProduto().getId();
    produto.setFornecedor(fornecedorService.buscarOuFalhar(fornecedorId));
    produto.setTipoProduto(tipoProdutoService.buscarOuFalhar(tipoProdutoId));

    return produtoRepository.save(produto);
  }

  public Produto buscarOuFalhar(Long produtoId) {
    return produtoRepository.findById(produtoId)
            .orElseThrow(() -> new ProdutoNaoEncontradoException(produtoId));
  }

  public void remover(Long produtoId) {
    Produto produto = buscarOuFalhar(produtoId);
    produtoRepository.delete(produto);
  }

}
