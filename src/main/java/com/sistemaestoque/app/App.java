package com.sistemaestoque.app;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.DuplicadoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
  private static Categorias categorias;
  private static Fornecedores fornecedoresDb;
  private static Estoque estoque;

  public static void main(String[] args)
      throws ValorInvalidoException, DescricaoEmBrancoException, DuplicadoException {
    Scanner scanner = new Scanner(System.in);
    categorias = new Categorias();
    fornecedoresDb = new Fornecedores();
    while (true) {
      App.menu();
      int option = scanner.nextInt();

      switch (option) {
        case 1:
          System.out.print("\033[H\033[2J");
          System.out.println("Escreva o nome da nova categoria: ");

          String nomeCategoria = scanner.next();

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
          break;
        case 3:
          System.out.print("\033[H\033[2J");
          System.out.flush();
          break;
        case 4:
          System.out.print("\033[H\033[2J");
          System.out.flush();
          break;
        case 5:
          System.out.print("\033[H\033[2J");
          System.out.flush();
          categorias.listaTudo();
          break;
        case 7:
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
    System.out.println("--------- 7. Sair                   ---------");
  }
}
