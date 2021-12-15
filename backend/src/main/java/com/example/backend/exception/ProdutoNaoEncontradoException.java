package com.example.backend.exception;

public class ProdutoNaoEncontradoException extends EntidadeNaoEncontradaException {
  public static final long serialVersionUID = 1L;

  public ProdutoNaoEncontradoException(String mensagem) {
    super(mensagem);
  }

  public ProdutoNaoEncontradoException(Long estadoId) {
    this("Não existe um cadastro de produto com código " + estadoId);
  }
}
