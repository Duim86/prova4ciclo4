package com.example.backend.dtos.assembler;

import com.example.backend.dtos.model.TipoProdutoListModel;
import com.example.backend.dtos.model.TipoProdutoModel;
import com.example.backend.model.TipoProduto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class TipoProdutoModelAssembler {

  @Autowired
  private ModelMapper modelMapper;

  public TipoProdutoModel toModel(TipoProduto tipoProduto) {
    return modelMapper.map(tipoProduto, TipoProdutoModel.class);
  }

  public TipoProdutoListModel toModelList(TipoProduto tipoProduto) {
    return modelMapper.map(tipoProduto, TipoProdutoListModel.class);
  }

  public List<TipoProdutoListModel> toCollectionModel(List<TipoProduto> tipoProduto){
    return tipoProduto.stream()
            .map(this::toModelList)
            .collect(Collectors.toList());
  }


}
