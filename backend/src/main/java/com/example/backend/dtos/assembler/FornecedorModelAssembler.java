package com.example.backend.dtos.assembler;

import com.example.backend.dtos.model.FornecedorListModel;
import com.example.backend.dtos.model.FornecedorModel;
import com.example.backend.model.Fornecedor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class FornecedorModelAssembler {

  @Autowired
  private ModelMapper modelMapper;

  public FornecedorModel toModel(Fornecedor fornecedor) {
    return modelMapper.map(fornecedor, FornecedorModel.class);
  }

  public FornecedorListModel toModelList(Fornecedor fornecedor) {
    return modelMapper.map(fornecedor, FornecedorListModel.class);
  }

  public List<FornecedorListModel> toCollectionModel(List<Fornecedor> fornecedors){
    return fornecedors.stream()
            .map(this::toModelList)
            .collect(Collectors.toList());
  }


}
