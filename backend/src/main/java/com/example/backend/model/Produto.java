package com.example.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;

  private BigDecimal precoVenda;
  private BigDecimal precoCompra;

  private Integer quantidade = 0;

  @ManyToOne
  private Fornecedor fornecedor;

  @ManyToOne
  private TipoProduto tipoProduto;
}


