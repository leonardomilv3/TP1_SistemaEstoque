package com.sistemaestoque.app;
import java.util.Scanner;

import com.sistemaestoque.app.exception.DescricaoEmBrancoException;
import com.sistemaestoque.app.exception.ValorInvalidoException;

public class App {
    private static Scanner scanner;
    private static Categorias categorias;
    public static void main(String[] args) throws ValorInvalidoException, DescricaoEmBrancoException{
        scanner = new Scanner(System.in);
        
        while (true) {
            App.menu();
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Escreva o nome da nova categoria: ");
                    String nomeCategoria = scanner.nextLine();
                    Categoria categoria = new Categoria(nomeCategoria);
                    
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
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
                    break;
                case 6:
                    System.exit(1);
                    break;
            
                default:
                    break;
                }
        }
            
     
        
    }

    private static void menu() {
        System.out.println("--------- SISTEMA DE ESTOQUE        ---------");
        System.out.println("--------- 1. Cadastro de Categoria  ---------");
        System.out.println("--------- 2. Cadastro de Fornecedor ---------");
        System.out.println("--------- 3. Cadastro de Produto    ---------");
        System.out.println("--------- 4. Listar Estoque         ---------");
        System.out.println("--------- 5. Relatório              ---------");
        System.out.println("--------- 6. Sair                   ---------");
    }
}
