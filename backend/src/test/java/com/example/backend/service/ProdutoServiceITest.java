package com.example.backend.service;
import com.example.backend.model.Fornecedor;
import com.example.backend.model.Produto;
import com.example.backend.model.TipoProduto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(value = "test")
public class ProdutoServiceITest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private Flyway flyway;

  @Autowired
  private ObjectMapper objectMapper;

  @BeforeEach
  void beforeEach() {
    flyway.clean();
    flyway.migrate();
  }

  @Test
  void deveRetornarTodosProdutos() throws Exception {
    mockMvc.perform(get("/produtos"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.*", hasSize(2)));
  }

  @Test
  void deveCriarProduto() throws Exception {
    var produto = new Produto();
    var tipoProduto = new TipoProduto();
    tipoProduto.setId(1L);
    var fornecedor = new Fornecedor();
    fornecedor.setId(1L);

    produto.setNome("Água");
    produto.setPrecoCompra(new BigDecimal("5"));
    produto.setPrecoVenda(new BigDecimal("3"));
    produto.setTipoProduto(tipoProduto);
    produto.setFornecedor(fornecedor);

    mockMvc
            .perform(post("/produtos")
                    .content(objectMapper.writeValueAsString(produto))
                    .contentType(APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isCreated());
  }



}
