# TP2_SistemaEstoque

O TP2 consiste em realizar uma análise sobre o código, com base em boas características de um bom projeto de software, observar os maus-cheiros presentes no sistema e aplicar a operação de refatoração capaz de levar o projeto de código a ter a característica analisada.

## Integrantes 

| Discente | Matrícula |
|--------- | --------- |
| André Macedo Rodrigues Alves | 190102390 |
| Thiago Siqueira Gomes | 190055294|


## Modularidade

### Algumas características de um código modularizado
- **Divisão em Módulos:** O código é dividido em módulos independentes, cada um responsável por uma função ou conjunto de funcionalidades específicas.

- **Encapsulamento:** Cada módulo encapsula sua própria lógica e funcionalidade, ocultando detalhes internos e expondo apenas uma interface clara para interações externas.

- **Baixo Acoplamento:** Os módulos têm baixo acoplamento entre si, ou seja, mudanças em um módulo não afetam diretamente outros módulos. Isso aumenta a flexibilidade do código.

- **Alta Coesão:** Cada módulo é altamente coeso, o que significa que as funcionalidades relacionadas estão agrupadas no mesmo módulo. Isso facilita a manutenção e compreensão do código.

- **Reusabilidade:** Os módulos são projetados para serem reutilizáveis em diferentes partes do sistema ou até mesmo em outros projetos. Isso economiza tempo e esforço ao evitar a necessidade de reescrever código semelhante.

### Code smell

Um code smell que indica um códgo mal modularizado é um método muito extenso.
No tp1 podemos encontrar um método que exemplifica esse code smell:

https://github.com/leonardomilv3/TP1_SistemaEstoque/blob/24efd607adb35cae9702b7543f29d8bb16e54dec/src/main/java/com/sistemaestoque/app/App.java#L18-L190

### Correção

Para corrigir o code smell acima, basta dividir cada uma das ações no switch case em novos métodos,
assim em cada um dos cases basta chamar o método responsável pela ação.

```java
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
          App.cadastraCategoria();
          break;
        case 2:
          App.cadastraFornecedor();
          break;
        case 3:
          App.cadastraProduto();
          break;
        case 4:
          App.cadastraListaEstoque();
          break;
        case 5:
          App.cadastraListaCategorias();
          break;
        case 6:
          App.compraProduto();
          break;
        case 7:
          App.histDeTransacoes();
          break;
        case 8:
          System.exit(1);
          break;
        default:
          break;
      }
    }
  }

```

## Ausência de duplicidades
### Algumas características de um código com ausência de duplicidade
- **Unicidade de Elementos:**  Cada componente, símbolo ou unidade no código é único. Não há repetição de elementos, garantindo uma singularidade para cada item no código.

- **Identificação Individual:** Cada elemento é distintamente identificável pelo seu valor único no código. Isso facilita a referência e o reconhecimento de cada parte do código de forma única.

- **Redução de Ambiguidade:** A ausência de duplicidade elimina ambiguidades que podem surgir quando elementos idênticos ou semelhantes estão presentes em um código. Isso torna a interpretação e o processamento do código mais claros e diretos.

- **Maior Eficiência na Organização:** Em muitos casos, códigos sem duplicidade podem simplificar processos de organização e armazenamento, pois não há necessidade de lidar com a redundância de elementos.

### Code smell

Quando partes idênticas ou semelhantes de código são encontradas em diferentes lugares, isso sugere falta de reutilização e pode levar à duplicação de elementos.

Um code smell que indica um código duplicado:
No tp1 podemos encontrar um método que exemplifica esse code smell:

```java
class Retangulo {
    double ladoA;
    double ladoB;
    
    double calcularArea() {
        return ladoA * ladoB;
    }
    
    double calcularPerimetro() {
        return 2 * (ladoA + ladoB);
    }
}

class Circulo {
    double raio;
    
    double calcularArea() {
        return Math.PI * raio * raio;
    }
    
    double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }
}
```

### Correção

Para resolver a duplicação no cálculo do perímetro, podemos criar uma classe abstrata Forma que contenha esse método e estender essa classe nas classes Retângulo e Círculo.

```java
abstract class Forma {
    abstract double calcularArea();
    abstract double calcularPerimetro();
}

class Retangulo extends Forma {
    double ladoA;
    double ladoB;
    
    double calcularArea() {
        return ladoA * ladoB;
    }
    
    double calcularPerimetro() {
        return 2 * (ladoA + ladoB);
    }
}

class Circulo extends Forma {
    double raio;
    
    double calcularArea() {
        return Math.PI * raio * raio;
    }
    
    double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }
}
```
