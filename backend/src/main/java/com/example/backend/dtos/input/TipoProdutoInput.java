package com.example.backend.dtos.input;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TipoProdutoInput {

  @NotBlank
  @ApiModelProperty(example = "Bebida", required = true)
  private String nome;

}
