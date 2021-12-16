package com.example.backend.dtos.model;

import com.example.backend.model.Fornecedor;
import com.example.backend.model.TipoProduto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoModel {

  @ApiModelProperty(example = "1")
  private Long id;

  @ApiModelProperty(example = "Bebida")
  private String nome;

  @ApiModelProperty(example = "7")
  private BigDecimal precoVenda;

  @ApiModelProperty(example = "5.20")
  private BigDecimal precoCompra;

  @ApiModelProperty(example = "0")
  private Integer quantidade;

  private FornecedorListModel fornecedor;
  private TipoProdutoListModel tipoProduto;




}
