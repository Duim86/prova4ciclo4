package com.example.backend.dtos.assembler;

import com.example.backend.dtos.model.ProdutoListModel;
import com.example.backend.dtos.model.ProdutoModel;
import com.example.backend.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProdutoModelAssembler {

  @Autowired
  private ModelMapper modelMapper;

  public ProdutoModel toModel(Produto produto) {
    return modelMapper.map(produto, ProdutoModel.class);
  }

  public ProdutoListModel toModelList(Produto produto) {
    return modelMapper.map(produto, ProdutoListModel.class);
  }

  public List<ProdutoListModel> toCollectionModel(List<Produto> produto){
    return produto.stream()
            .map(this::toModelList)
            .collect(Collectors.toList());
  }


}
