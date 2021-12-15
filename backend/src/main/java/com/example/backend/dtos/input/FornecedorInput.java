package com.example.backend.dtos.input;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class FornecedorInput {

  @NotBlank
  @ApiModelProperty(example = "Disk Duim", required = true)
  private String nome;

}
