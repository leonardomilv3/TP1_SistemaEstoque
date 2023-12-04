package com.sistemaestoque.app;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.DuplicadoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class App {
  private static Categorias categorias;
  private static Fornecedores fornecedoresDb;
  private static ArrayList<String> historico;
  private static Estoque estoque;

  public static void main(String[] args)
      throws ValorInvalidoException, DescricaoEmBrancoException, DuplicadoException {
    Scanner scanner = new Scanner(System.in);
    categorias = new Categorias();
    fornecedoresDb = new Fornecedores();
    estoque = new Estoque();
    historico = new ArrayList();

    // cadastra fornecedor padrao 
    Fornecedor df = new Fornecedor(1, "default");
    fornecedoresDb.cadastraFornecedor(df);

    while (true) {
      App.menu();
      int option = scanner.nextInt();

      switch (option) {
        case 1:
          System.out.print("\033[H\033[2J");
          System.out.println("Escreva o nome da nova categoria: ");

          scanner.nextLine();
          String nomeCategoria = scanner.nextLine();

          Categoria categoria = new Categoria(nomeCategoria);
          categorias.adiciona(categoria);
          break;
        case 2:
          System.out.print("\033[H\033[2J");
          System.out.flush();

          System.out.print("CADASTRO DE FORNECEDOR\n");
          System.out.print("Nome: ");
          scanner.nextLine(); // remove '\n'
          String nome = scanner.nextLine();
          int id = 1;
          ArrayList<Fornecedor> fList = fornecedoresDb.listarFornecedores();
          if(!fList.isEmpty()) {
            id = fList.get(fList.size()-1).getId();
          }
          Fornecedor f = new Fornecedor(id, nome);
          fornecedoresDb.cadastraFornecedor(f);
          System.out.print("FORNECEDOR CADASTRADO\n");
          break;
        case 3:
          System.out.print("\033[H\033[2J");
          System.out.flush();
          scanner.nextLine(); // remove '\n'
                              //
          System.out.print("CADASTRO DE PRODUTO\n");
          
          System.out.print("Nome: ");
          String nomeProd = scanner.nextLine();
          System.out.print("Descrição: ");
          String descricao = scanner.nextLine();
          System.out.print("Código de barras: ");
          String codigoBarras = scanner.nextLine();
          System.out.print("Preço (Custo): ");
          float precoCusto = scanner.nextFloat();
          System.out.print("Preço (Venda): ");
          float precoVenda = scanner.nextFloat();
          System.out.print("Quantidade: ");
          int qtdDisponivel = scanner.nextInt();
          int idFornecedor = 1;
          System.out.print("Ano do vencimento: ");
          int dataA = scanner.nextInt();
          System.out.print("Mês do vencimento: ");
          int dataM = scanner.nextInt();
          //scanner.nextLine(); // remove '\n'

          Date dataValidade = new Date();
          dataValidade.setMonth(dataM);
          dataValidade.setYear(dataA);

          Produto p = new Produto(nomeProd, descricao, codigoBarras,
              precoCusto, precoVenda, qtdDisponivel, fornecedoresDb.listarFornecedores().get(0), dataValidade);
          estoque.armazenaProduto(p);
          System.out.print("PRODUTO CADASTRADO!\n");
          break;
        case 4:
          System.out.print("\033[H\033[2J");
          System.out.flush();
          List<Produto> prodList = estoque.listaProdutosArmazenados();
          System.out.println("Código de barras | Nome | Qtd. | Preço | Data de validade\n");
          int cnt = 1;
          for(Produto prod : prodList) {
            System.out.print(cnt + ": ");
            System.out.print(prod.getCodigoBarras() + " | ");
            System.out.print(prod.getNome() + " | ");
            System.out.print(prod.getQtdDisponivel() + " | ");
            System.out.print(prod.getPrecoVenda() + " | ");
            System.out.print(prod.getDataValidade().getMonth() + "/" 
                + prod.getDataValidade().getYear() + "\n");
            cnt++;
          }
          break;
        case 5:
          System.out.print("\033[H\033[2J");
          System.out.flush();
          categorias.listaTudo();
          break;
        case 7:
            System.out.print("\033[H\033[2J");
            System.out.flush();
            prodList = estoque.listaProdutosArmazenados();
            System.out.println("Produtos disponíveis: ");
            if(prodList.size() == 0 ){
              System.out.println("Não há produtos ainda");
              break;
            }
            for(Produto prod : prodList) {
              System.out.print(prod.getNome() + ":" + prod.getCodigoBarras() + "\n");
            }
            System.out.println("Digite o código de barras de um produto: ");
            String codigo = scanner.next();
            System.out.println("Digite a quantidade desejada: ");
            int quantidade = scanner.nextInt();
            Produto estoquePorCodigo = estoque.consultaEstoquePorCodigo(codigo);
            System.out.println("Compra feita! Preço: " + quantidade * estoquePorCodigo.getPrecoVenda());
            LocalDate dataCompra = LocalDate.now();
            historico.add(estoquePorCodigo.getNome()
                + " | " + estoquePorCodigo.getQtdDisponivel()
                + " | " + estoquePorCodigo.getPrecoVenda()
                + " | " + estoquePorCodigo.getPrecoVenda()*quantidade
                + " | " + estoquePorCodigo.getQtdDisponivel()
                + " | " + dataCompra);
            estoquePorCodigo.diminuiQtdDisponivel(quantidade);
          break;
        case 8:
          System.out.print("\033[H\033[2J");
          System.out.flush();
          System.out.print("COMPRAS REALIZADAS\n");
          System.out.println("Nome | Qtd. | Preço | Total | Data\n");
          cnt = 1;
          for(String compra: historico) {
            System.out.println(cnt + ": ");
            System.out.println(compra + "\n");
            cnt++;
          }
          break;
        case 9:
          System.exit(1);
          break;
        default:
          break;
      }
    }
  }

  private static void menu() {
    System.out.println("\n\n--------- SISTEMA DE ESTOQUE        ---------");
    System.out.println("--------- 1. Cadastro de Categoria  ---------");
    System.out.println("--------- 2. Cadastro de Fornecedor ---------");
    System.out.println("--------- 3. Cadastro de Produto    ---------");
    System.out.println("--------- 4. Listar Estoque         ---------");
    System.out.println("--------- 5. Listar Categorias      ---------");
    System.out.println("--------- 6. Relatório              ---------");
    System.out.println("--------- 7. Comprar                ---------");
    System.out.println("--------- 8. Hist. de transações    ---------");
    System.out.println("--------- 9. Sair                   ---------");
  }
}
