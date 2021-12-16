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
    var fornecedor = fornecedorService.buscarOuFalhar(fornecedorId);
    var tipoProduto = tipoProdutoService.buscarOuFalhar(tipoProdutoId);
    produto.setFornecedor(fornecedor);
    produto.setTipoProduto(tipoProduto);

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

  @Transactional
  public void adicionarEstoque(Long produtoId, Integer quantidade) {
    var produto = buscarOuFalhar(produtoId);
    produto.setQuantidade(produto.getQuantidade() + quantidade);
  }

  @Transactional
  public void removerEstoque(Long produtoId, Integer quantidade) {
    var produto = buscarOuFalhar(produtoId);
    if(produto.getQuantidade() < quantidade) {
      throw new IllegalStateException("Quantidade maior que disponivel no estoque");
    }

    produto.setQuantidade(produto.getQuantidade() - quantidade);
  }
}
