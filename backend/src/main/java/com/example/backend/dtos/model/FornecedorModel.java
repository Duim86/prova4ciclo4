package com.example.backend.dtos.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FornecedorModel {

  @ApiModelProperty(example = "1")
  private Long id;

  @ApiModelProperty(example = "Disk Duim")
  private String nome;
}
