package com.example.backend.controller;

import com.example.backend.model.TipoProduto;
import com.example.backend.service.TipoProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tipoProdutos")
public class TipoProdutoController {

  private final TipoProdutoService tipoProdutoService;

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<TipoProduto> listar() {
    return tipoProdutoService.listar();
  }

  @GetMapping("/{tipoProdutoId}")
  @ResponseStatus(HttpStatus.OK)
  public TipoProduto buscar(@PathVariable Long tipoProdutoId) {
    return tipoProdutoService.buscarOuFalhar(tipoProdutoId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public TipoProduto adicionar(@RequestBody TipoProduto tipoProduto) {
    return tipoProdutoService.adicionar(tipoProduto);
  }

  @PutMapping("/{tipoProdutoId}")
  public TipoProduto atualizar(@PathVariable Long tipoProdutoId,
                           @RequestBody TipoProduto tipoProduto){
    return tipoProdutoService.atualizar(tipoProdutoId, tipoProduto);
  }

  @DeleteMapping("/{tipoProdutoId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long tipoProdutoId) {
    tipoProdutoService.remover(tipoProdutoId);
  }
}
