package com.example.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class TipoProduto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;

  @OneToMany(mappedBy = "tipoProduto")
  private List<Produto> produtoLista;
}
