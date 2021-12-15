package com.example.backend.service;

import com.example.backend.exception.TipoProdutoNaoEncontradoException;
import com.example.backend.model.TipoProduto;
import com.example.backend.repository.TipoProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoProdutoService {

  private final TipoProdutoRepository tipoProdutoRepository;

  public List<TipoProduto> listar() {
    return tipoProdutoRepository.findAll();
  }

  public TipoProduto adicionar(TipoProduto tipoProduto) {
    return tipoProdutoRepository.save(tipoProduto);
  }

  public TipoProduto buscarOuFalhar(Long tipoProdutoId) {
    return tipoProdutoRepository.findById(tipoProdutoId)
            .orElseThrow(() -> new TipoProdutoNaoEncontradoException(tipoProdutoId));
  }

  public TipoProduto atualizar(Long tipoProdutoId, TipoProduto tipoProduto) {
    TipoProduto tipoProdutoAtual = buscarOuFalhar(tipoProdutoId);
    tipoProdutoAtual.setNome(tipoProduto.getNome());
    return tipoProdutoRepository.save(tipoProdutoAtual);
  }

  public void remover(Long tipoProdutoId) {
    TipoProduto tipoProduto = buscarOuFalhar(tipoProdutoId);
    tipoProdutoRepository.delete(tipoProduto);
  }
  
}
