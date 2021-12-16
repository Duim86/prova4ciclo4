package com.example.backend.service;

import com.example.backend.exception.NegocioException;
import com.example.backend.model.Produto;
import com.example.backend.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {
  @InjectMocks
  private ProdutoService produtoService;

  @Mock
  private ProdutoRepository produtoRepository;

  @Test
  void deveAdicionarProdutoEstoque(){
    var produtoId = 4L;
    var quantidade = 5;
    var produto = criaProduto();

    Mockito.when(produtoRepository.findById(produtoId)).thenReturn(Optional.of(produto));

    produtoService.adicionarEstoque(produtoId, quantidade);

    assertEquals(8, produto.getQuantidade());

  }

  @Test
  void deveRemoverProdutoQuandoEstoqueSuficiente(){
    var produtoId = 4L;
    var quantidade = 2;
    var produto = criaProduto();

    Mockito.when(produtoRepository.findById(produtoId)).thenReturn(Optional.of(produto));

    produtoService.removerEstoque(produtoId, quantidade);

    assertEquals(1, produto.getQuantidade());

  }

  @Test
  void deveFalharAoRemoverProdutoQuandoEstoqueInsuficiente(){
    var produtoId = 4L;
    var quantidade = 5;
    var produto = criaProduto();

    Mockito.when(produtoRepository.findById(produtoId)).thenReturn(Optional.of(produto));



    assertThrows(NegocioException.class, () -> produtoService.removerEstoque(produtoId, quantidade));

  }

  Produto criaProduto() {
    var produto = new Produto();
    produto.setQuantidade(3);
    return produto;
  }
}
