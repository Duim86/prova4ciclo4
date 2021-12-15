package com.example.backend.controller;

import com.example.backend.dtos.assembler.FornecedorModelAssembler;
import com.example.backend.dtos.disassembler.FornecedorInputDisassembler;
import com.example.backend.dtos.input.FornecedorInput;
import com.example.backend.dtos.model.FornecedorListModel;
import com.example.backend.dtos.model.FornecedorModel;
import com.example.backend.service.FornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fornecedores")
public class FornecedorController {

  private final FornecedorService fornecedorService;
  private final FornecedorInputDisassembler fornecedorInputDisassembler;
  private final FornecedorModelAssembler fornecedorModelAssembler;

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<FornecedorListModel> listar() {
    return fornecedorModelAssembler.toCollectionModel(fornecedorService.listar());
  }

  @GetMapping("/{fornecedorId}")
  @ResponseStatus(HttpStatus.OK)
  public FornecedorModel buscar(@PathVariable Long fornecedorId) {
    return fornecedorModelAssembler.toModel(fornecedorService.buscarOuFalhar(fornecedorId));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FornecedorModel adicionar(@RequestBody @Valid FornecedorInput fornecedorInput) {
    var fornecedor = fornecedorInputDisassembler.toDomainObject(fornecedorInput);
    return fornecedorModelAssembler.toModel(fornecedorService.adicionar(fornecedor));
  }

  @PutMapping("/{fornecedorId}")
  public FornecedorModel atualizar(@PathVariable Long fornecedorId,
                           @RequestBody @Valid FornecedorInput fornecedorInput){
    var fornecedorAtual = fornecedorService.buscarOuFalhar(fornecedorId);
    fornecedorInputDisassembler.copyToDomainObject(fornecedorInput, fornecedorAtual);

    return fornecedorModelAssembler.toModel(fornecedorService.adicionar(fornecedorAtual));
  }

  @DeleteMapping("/{fornecedorId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long fornecedorId) {
    fornecedorService.remover(fornecedorId);
  }
}
