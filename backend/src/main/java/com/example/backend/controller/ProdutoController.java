package com.example.backend.controller;

import com.example.backend.dtos.assembler.ProdutoModelAssembler;
import com.example.backend.dtos.disassembler.ProdutoInputDisassembler;
import com.example.backend.dtos.input.ProdutoInput;
import com.example.backend.dtos.model.ProdutoListModel;
import com.example.backend.dtos.model.ProdutoModel;
import com.example.backend.model.Fornecedor;
import com.example.backend.model.TipoProduto;
import com.example.backend.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produtos")
@CrossOrigin(origins = "http://localhost:3000")
public class ProdutoController {

  private final ProdutoService produtoService;
  private final ProdutoModelAssembler produtoModelAssembler;
  private final ProdutoInputDisassembler produtoInputDisassembler;

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<ProdutoListModel> listar() {
    return produtoModelAssembler.toCollectionModel(produtoService.listar());
  }

  @GetMapping("/{produtoId}")
  @ResponseStatus(HttpStatus.OK)
  public ProdutoModel buscar(@PathVariable Long produtoId) {
    return produtoModelAssembler.toModel(produtoService.buscarOuFalhar(produtoId));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProdutoModel adicionar(@RequestBody @Valid ProdutoInput produtoInput) {
    var produto = produtoInputDisassembler.toDomainObject(produtoInput);
    return produtoModelAssembler.toModel(produtoService.adicionar(produto));
  }

  @PutMapping("/{produtoId}")
  public ProdutoModel atualizar(@PathVariable Long produtoId,
                           @RequestBody @Valid ProdutoInput produtoInput){
    var produtoAtual = produtoService.buscarOuFalhar(produtoId);
    produtoAtual.setTipoProduto(new TipoProduto());
    produtoAtual.setFornecedor(new Fornecedor());
    produtoInputDisassembler.copyToDomainObject(produtoInput, produtoAtual);

    return produtoModelAssembler.toModel(produtoService.adicionar(produtoAtual));
  }

  @DeleteMapping("/{produtoId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long produtoId) {
    produtoService.remover(produtoId);
  }

  @PutMapping("/{produtoId}/adicionarEstoque")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void adicionarEstoque(@PathVariable Long produtoId, @RequestBody Integer quantidade) {
    produtoService.adicionarEstoque(produtoId, quantidade);
  }

  @PutMapping("/{produtoId}/removerEstoque")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void removerEstoque(@PathVariable Long produtoId, @RequestBody Integer quantidade) {
    produtoService.removerEstoque(produtoId, quantidade);
  }
}
