package com.example.backend.controller;

import com.example.backend.model.Produto;
import com.example.backend.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

  private final ProdutoService produtoService;

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<Produto> listar() {
    return produtoService.listar();
  }

  @GetMapping("/{produtoId}")
  @ResponseStatus(HttpStatus.OK)
  public Produto buscar(@PathVariable Long produtoId) {
    return produtoService.buscarOuFalhar(produtoId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Produto adicionar(@RequestBody Produto produto) {
    return produtoService.adicionar(produto);
  }

  @PutMapping("/{produtoId}")
  public Produto atualizar(@PathVariable Long produtoId,
                           @RequestBody Produto produto){
    return produtoService.atualizar(produtoId, produto);
  }

  @DeleteMapping("/{produtoId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long produtoId) {
    produtoService.remover(produtoId);
  }
}
