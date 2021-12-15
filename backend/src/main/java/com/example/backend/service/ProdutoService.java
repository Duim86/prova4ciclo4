package com.example.backend.service;

import com.example.backend.exception.ProdutoNaoEncontradoException;
import com.example.backend.model.Produto;
import com.example.backend.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

  private final ProdutoRepository produtoRepository;

  public List<Produto> listar() {
    return produtoRepository.findAll();
  }

  public Produto adicionar(Produto produto) {
    return produtoRepository.save(produto);
  }

  public Produto buscarOuFalhar(Long produtoId) {
    return produtoRepository.findById(produtoId)
            .orElseThrow(() -> new ProdutoNaoEncontradoException(produtoId));
  }

  public Produto atualizar(Long produtoId, Produto produto) {
    Produto produtoAtual = buscarOuFalhar(produtoId);
    
    produtoAtual.setNome(produto.getNome());
    produtoAtual.setPrecoCompra(produto.getPrecoCompra());
    produtoAtual.setPrecoVenda(produto.getPrecoVenda());
    
    return produtoRepository.save(produtoAtual);
  }

  public void remover(Long produtoId) {
    Produto produto = buscarOuFalhar(produtoId);
    produtoRepository.delete(produto);
  }
  
}
