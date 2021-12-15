package com.example.backend.dtos.disassembler;

import com.example.backend.dtos.input.TipoProdutoInput;
import com.example.backend.model.TipoProduto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TipoProdutoInputDisassembler {

  @Autowired
  private ModelMapper modelMapper;

  public TipoProduto toDomainObject(TipoProdutoInput tipoProdutoInput) {
    return modelMapper.map(tipoProdutoInput, TipoProduto.class);
  }

  public void copyToDomainObject(TipoProdutoInput tipoProdutoInput, TipoProduto tipoProduto) {

    modelMapper.map(tipoProdutoInput, tipoProduto);
  }
}
