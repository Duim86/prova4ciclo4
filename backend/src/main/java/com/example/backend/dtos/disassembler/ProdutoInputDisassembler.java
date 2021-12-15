package com.example.backend.dtos.disassembler;

import com.example.backend.dtos.input.ProdutoInput;
import com.example.backend.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoInputDisassembler {

  @Autowired
  private ModelMapper modelMapper;

  public Produto toDomainObject(ProdutoInput produtoInput) {
    return modelMapper.map(produtoInput, Produto.class);
  }

  public void copyToDomainObject(ProdutoInput produtoInput, Produto produto) {

    modelMapper.map(produtoInput, produto);
  }
}
