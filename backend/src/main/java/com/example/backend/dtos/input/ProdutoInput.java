package com.example.backend.dtos.input;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoInput {

  @NotBlank
  @ApiModelProperty(example = "Cerveja", required = true, position = 1)
  private String nome;

  @NotNull
  @ApiModelProperty(example = "2.58", required = true, position = 5)
  private BigDecimal precoCompra;

  @NotNull
  @ApiModelProperty(example = "3.18", required = true, position = 10)
  private BigDecimal precoVenda;

  @Valid
  @NotNull
  @ApiModelProperty(required = true, position = 15)
  private FornecedorIdInput fornecedor;

  @Valid
  @NotNull
  @ApiModelProperty(required = true, position = 20)
  private TipoProdutoIdInput tipoProduto;
}
