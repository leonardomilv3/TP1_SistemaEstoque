package com.sistemaestoque.app;

import static org.junit.jupiter.api.Assertions.*;

import com.sistemaestoque.app.exception.*;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class EstoqueTest {

  Estoque estoque;

  @BeforeEach
  public void setup() {
    estoque = new Estoque();
  }

  @Test
  void testArmazenaUmProdutoNoEstoque() throws DescricaoEmBrancoException, ValorInvalidoException {
    Fornecedor forn = new Fornecedor();
    Produto prod1 =
        new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 20, forn, new Date());
    estoque.armazenaProduto(prod1);
    assertEquals(1, estoque.listaProdutosArmazenados().size());
  }

  @Test
  void testAlertaEstoqueBaixoUmProduto() throws DescricaoEmBrancoException, ValorInvalidoException {
    Fornecedor forn = new Fornecedor();
    Produto prod1 =
        new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 1, forn, new Date());
    estoque.adicionarObservador(new AlertaEstoqueBaixo());
    assertEquals(
        "Produto: Sabonete | Qtd disponível: 1", estoque.notificarObservadoresBaixoEstoque(prod1));
  }

  @Test
  void testAlertaEstoqueBaixoDoisProduto()
      throws DescricaoEmBrancoException, ValorInvalidoException {
    Fornecedor forn = new Fornecedor();
    Produto prod1 =
        new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 1, forn, new Date());
    Produto prod2 =
        new Produto("Caixa Ovos", "Mercearia", "0001", 15.0f, 20.0f, 3, forn, new Date());

    estoque.adicionarObservador(new AlertaEstoqueBaixo());
    estoque.armazenaProduto(prod1);
    estoque.armazenaProduto(prod2);

    assertEquals(
        "Produto: Sabonete | Qtd disponível: 1", estoque.notificarObservadoresBaixoEstoque(prod1));
    assertEquals(
        "Produto: Caixa Ovos | Qtd disponível: 3",
        estoque.notificarObservadoresBaixoEstoque(prod2));
  }

  @Test
  void testConsultaProdutoPorNome() throws DescricaoEmBrancoException, ValorInvalidoException {
    Fornecedor forn = new Fornecedor(1, "Natura");
    Produto prod1 =
        new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 1, forn, new Date());
    estoque.armazenaProduto(prod1);

    assertNotNull(estoque.consultaEstoquePorNome("Sabonete"));
    assertNull(estoque.consultaEstoquePorNome("Agua"));
  }

  @Test
  void testConsultaProdutoPorCodigo() throws DescricaoEmBrancoException, ValorInvalidoException {
    Fornecedor forn = new Fornecedor(1, "Natura");
    Produto prod1 =
        new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 1, forn, new Date());
    estoque.armazenaProduto(prod1);

    assertNotNull(estoque.consultaEstoquePorCodigo("0000"));
    assertNull(estoque.consultaEstoquePorCodigo("1234"));
  }

  @ParameterizedTest
  @MethodSource("produtosProvider")
  void testConsultaProdutoPorCodigo(Produto produto) {
    estoque.armazenaProduto(produto);
    assertNotNull(estoque.consultaEstoquePorCodigo(produto.getCodigoBarras()));
  }

  private static Stream<Produto> produtosProvider()
      throws DescricaoEmBrancoException, ValorInvalidoException {
    Fornecedor forn = new Fornecedor(1, "Natura");
    Produto prod1 =
        new Produto("Sabão em pó", "Produto de limpeza", "0000", 2.0f, 3.0f, 1, forn, new Date());
    Produto prod2 =
        new Produto("Sabonete", "Produto de limpeza", "1234", 2.0f, 3.0f, 1, forn, new Date());
    Produto prod3 =
        new Produto(
            "Esponja de limpesa", "Produto de limpeza", "4321", 2.0f, 3.0f, 1, forn, new Date());
    return Stream.of(prod1, prod2, prod3);
  }

  @ParameterizedTest
  @MethodSource("getParameters")
  void testAlertaProdutoProximoDaDataDeValidade(Produto produto, boolean expectedResult) {
    estoque.armazenaProduto(produto);
    assertEquals(expectedResult, estoque.alertaProdutoProximoDaValidade());
  }

  private static Stream<Arguments> getParameters()
      throws DescricaoEmBrancoException, ValorInvalidoException {
    Fornecedor forn = new Fornecedor(1, "Natura");
    Produto prod1 =
        new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 1, forn, new Date());

    Date dataAtual = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(dataAtual);
    calendar.add(Calendar.DAY_OF_MONTH, 5);
    Date dataFutura = calendar.getTime();

    Produto prod2 =
        new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 1, forn, dataFutura);

    Date dataAtualProd3 = new Date();
    Calendar calendarProd3 = Calendar.getInstance();
    calendarProd3.setTime(dataAtualProd3);
    calendarProd3.add(Calendar.DAY_OF_MONTH, 20);
    Date dataFuturaProd3 = calendarProd3.getTime();

    Produto prod3 =
        new Produto("Sabonete", "Produto de limpeza", "0000", 2.0f, 3.0f, 1, forn, dataFuturaProd3);

    return Stream.of(
        Arguments.of(prod1, true), Arguments.of(prod2, true), Arguments.of(prod3, false));
  }
}
