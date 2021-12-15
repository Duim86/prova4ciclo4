package com.example.backend.service;

import com.example.backend.exception.FornecedorNaoEncontradoException;
import com.example.backend.model.Fornecedor;
import com.example.backend.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FornecedorService {

  private final FornecedorRepository fornecedorRepository;

  public List<Fornecedor> listar() {
    return fornecedorRepository.findAll();
  }

  public Fornecedor adicionar(Fornecedor fornecedor) {
    return fornecedorRepository.save(fornecedor);
  }

  public Fornecedor buscarOuFalhar(Long fornecedorId) {
    return fornecedorRepository.findById(fornecedorId)
            .orElseThrow(() -> new FornecedorNaoEncontradoException(fornecedorId));
  }

  public Fornecedor atualizar(Long fornecedorId, Fornecedor fornecedor) {
    Fornecedor fornecedorAtual = buscarOuFalhar(fornecedorId);
    
    fornecedorAtual.setNome(fornecedor.getNome());
    
    return fornecedorRepository.save(fornecedorAtual);
  }

  public void remover(Long fornecedorId) {
    Fornecedor fornecedor = buscarOuFalhar(fornecedorId);
    fornecedorRepository.delete(fornecedor);
  }
  
}
