package com.example.backend.controller;

import com.example.backend.dtos.assembler.ProdutoModelAssembler;
import com.example.backend.dtos.model.ProdutoListModel;
import com.example.backend.repository.ProdutoRepository;
import com.example.backend.service.FornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fornecedores/{fornecedorId}/produtos")
public class FornecedorProdutoController {

  private final ProdutoRepository produtoRepository;
  private final FornecedorService fornecedorService;
  private final ProdutoModelAssembler produtoModelAssembler;

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<ProdutoListModel> listar(@PathVariable Long fornecedorId) {
    var fornecedor = fornecedorService.buscarOuFalhar(fornecedorId);

    return produtoModelAssembler.toCollectionModel(produtoRepository.findAllByFornecedor(fornecedor));
  }
}
