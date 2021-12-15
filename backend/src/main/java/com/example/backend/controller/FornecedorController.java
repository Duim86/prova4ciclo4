package com.example.backend.controller;

import com.example.backend.model.Fornecedor;
import com.example.backend.service.FornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fornecedores")
public class FornecedorController {

  private final FornecedorService fornecedorService;

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<Fornecedor> listar() {
    return fornecedorService.listar();
  }

  @GetMapping("/{fornecedorId}")
  @ResponseStatus(HttpStatus.OK)
  public Fornecedor buscar(@PathVariable Long fornecedorId) {
    return fornecedorService.buscarOuFalhar(fornecedorId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Fornecedor adicionar(@RequestBody Fornecedor fornecedor) {
    return fornecedorService.adicionar(fornecedor);
  }

  @PutMapping("/{fornecedorId}")
  public Fornecedor atualizar(@PathVariable Long fornecedorId,
                           @RequestBody Fornecedor fornecedor){
    return fornecedorService.atualizar(fornecedorId, fornecedor);
  }

  @DeleteMapping("/{fornecedorId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long fornecedorId) {
    fornecedorService.remover(fornecedorId);
  }
}
