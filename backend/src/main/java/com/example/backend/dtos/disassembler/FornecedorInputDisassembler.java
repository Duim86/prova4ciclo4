package com.example.backend.dtos.disassembler;

import com.example.backend.dtos.input.FornecedorInput;
import com.example.backend.model.Fornecedor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FornecedorInputDisassembler {

  @Autowired
  private ModelMapper modelMapper;

  public Fornecedor toDomainObject(FornecedorInput fornecedor) {
    return modelMapper.map(fornecedor, Fornecedor.class);
  }

  public void copyToDomainObject(FornecedorInput fornecedorInput, Fornecedor fornecedor) {

    modelMapper.map(fornecedorInput, fornecedor);
  }
}
