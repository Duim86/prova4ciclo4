package com.example.backend.exception;

public class FornecedorNaoEncontradoException extends EntidadeNaoEncontradaException {
  public static final long serialVersionUID = 1L;

  public FornecedorNaoEncontradoException(String mensagem) {
    super(mensagem);
  }

  public FornecedorNaoEncontradoException(Long estadoId) {
    this("Não existe um cadastro de fornecedor com código " + estadoId);
  }
}
