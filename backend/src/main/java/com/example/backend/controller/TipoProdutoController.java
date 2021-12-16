package com.example.backend.controller;

import com.example.backend.dtos.assembler.TipoProdutoModelAssembler;
import com.example.backend.dtos.disassembler.TipoProdutoInputDisassembler;
import com.example.backend.dtos.input.TipoProdutoInput;
import com.example.backend.dtos.model.TipoProdutoListModel;
import com.example.backend.dtos.model.TipoProdutoModel;
import com.example.backend.service.TipoProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tiposProduto")
@CrossOrigin(origins = "http://localhost:3000")
public class TipoProdutoController {

  private final TipoProdutoService tipoProdutoService;
  private final TipoProdutoModelAssembler tipoProdutoModelAssembler;
  private final TipoProdutoInputDisassembler tipoProdutoInputDisassembler;

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<TipoProdutoListModel> listar() {
    return tipoProdutoModelAssembler.toCollectionModel(tipoProdutoService.listar());
  }

  @GetMapping("/{tipoProdutoId}")
  @ResponseStatus(HttpStatus.OK)
  public TipoProdutoModel buscar(@PathVariable Long tipoProdutoId) {
    return tipoProdutoModelAssembler.toModel(tipoProdutoService.buscarOuFalhar(tipoProdutoId));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public TipoProdutoModel adicionar(@RequestBody @Valid TipoProdutoInput tipoProdutoInput) {
    var tipoProduto = tipoProdutoInputDisassembler.toDomainObject(tipoProdutoInput);
    return tipoProdutoModelAssembler.toModel(tipoProdutoService.adicionar(tipoProduto));
  }

  @PutMapping("/{tipoProdutoId}")
  public TipoProdutoModel atualizar(@PathVariable Long tipoProdutoId,
                           @RequestBody @Valid TipoProdutoInput tipoProdutoInput){
    var tipoProdutoAtual = tipoProdutoService.buscarOuFalhar(tipoProdutoId);
    tipoProdutoInputDisassembler.copyToDomainObject(tipoProdutoInput, tipoProdutoAtual);

    return tipoProdutoModelAssembler.toModel(tipoProdutoService.adicionar(tipoProdutoAtual));
  }

  @DeleteMapping("/{tipoProdutoId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long tipoProdutoId) {
    tipoProdutoService.remover(tipoProdutoId);
  }
}
