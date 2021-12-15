package com.example.backend.dtos.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FornecedorListModel {

  @ApiModelProperty(example = "1")
  private Long id;

  @ApiModelProperty(example = "Disk Duim")
  private String nome;
}
