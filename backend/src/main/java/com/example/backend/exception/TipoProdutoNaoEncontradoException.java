package com.example.backend.exception;

public class TipoProdutoNaoEncontradoException extends EntidadeNaoEncontradaException {
  public static final long serialVersionUID = 1L;

  public TipoProdutoNaoEncontradoException(String mensagem) {
    super(mensagem);
  }

  public TipoProdutoNaoEncontradoException(Long estadoId) {
    this("Não existe um cadastro de tipo produto com código " + estadoId);
  }
}
