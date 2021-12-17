package com.example.selenium;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
  MainPage mainPage = new MainPage();

  @BeforeEach
  void setUp() {
    Configuration.browserSize = "1280x800";
    SelenideLogger.addListener("allure", new AllureSelenide());
    open("http://localhost:3000");
  }

  @AfterEach
  void teardown() {
    Selenide.closeWebDriver();
  }

  @Test
  void deveCadastrarUmNovoFornecedorQuandoDadosForemInformadosCorretamente() {
      $("[id='id-fornecedor']").click();
      $("[id='btn-novo-fornecedor']").click();
      $("[name='nome']").sendKeys("Loja do Lucas");
      $("[id='btn-cadastrar']").click();

    Alert alert = Selenide.switchTo().alert();
    String actualMessage = alert.getText();
    String expectedMessage =  "Cadastro realizado com sucesso!";

    Assertions.assertEquals(expectedMessage, actualMessage);

  }

  @Test
  void deveCadastrarUmNovoTipoProdutoQuandoDadosForemInformadosCorretamente() {
    $("[id='id-tipoProduto']").click();
    $("[id='btn-novo-tiposProduto']").click();
    $("[name='nome']").sendKeys("Comida");
    $("[id='btn-cadastrar']").click();

    Alert alert = Selenide.switchTo().alert();
    String actualMessage = alert.getText();
    String expectedMessage =  "Cadastro realizado com sucesso!";

    Assertions.assertEquals(expectedMessage, actualMessage);

  }
}
