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


## Portabilidade
### Algumas características de um código com boa portabilidade

- **Compatibilidade entre plataformas:** Ao seguir padrões e práticas de codificação que são independentes de plataforma, o código pode ser executado em diferentes sistemas operacionais ou ambientes sem a necessidade de grandes modificações. Isso aumenta a flexibilidade do software e amplia seu alcance.

- **Manutenção simplificada:** Código portátil tende a ser mais fácil de manter. Quando atualizações ou correções são necessárias, não há a necessidade de reescrever partes inteiras do código para torná-lo compatível com diferentes sistemas. Isso economiza tempo e recursos.

- **Reutilização de código:** A portabilidade muitas vezes está ligada à modularidade e à reutilização de componentes. Códigos independentes de plataforma podem ser reutilizados em diferentes projetos ou em diferentes partes do mesmo projeto, reduzindo a redundância e aumentando a eficiência no desenvolvimento.

- **Acesso a diferentes mercados:** Com a portabilidade, um software pode ser facilmente adaptado para atender a diferentes demandas de mercado. Isso é crucial em um mundo onde diferentes dispositivos e sistemas operacionais coexistem e têm seu próprio público-alvo.

### Code smell

A ausência de portabilidade no código pode ser associada a um problema conhecido como "Dependência do Ambiente". Isso ocorre quando o código está intimamente ligado a um ambiente específico, como um sistema operacional, uma plataforma ou um contexto de execução.

A ausencia de portabilidae pode ser verificada no seguinte codigo:

```java
public class ExemploPortabilidade {
    public static void main(String[] args) {
        if (System.getProperty("os.name").startsWith("Windows")) {
            executarWindows();
        } else {
            executarOutroSistema();
        }
    }
    
    public static void executarWindows() {
        System.out.println("Executando no Windows");
    }
    
    public static void executarOutroSistema() {
        System.out.println("Executando em outro sistema");
    }
}
```

### Correção

Neste exemplo, o código original tinha lógica específica para determinar o sistema operacional e executar diferentes métodos com base nisso. Na refatoração, foi introduzida uma interface SistemaOperacional que define um método executar(). Em seguida, foram criadas classes concretas Windows e OutroSistema que implementam essa interface e contêm a lógica específica para cada sistema operacional.

```java
public class ExemploPortabilidade {
    public static void main(String[] args) {
        SistemaOperacional sistema = SistemaOperacionalFactory.getSistemaOperacional();
        sistema.executar();
    }
}

interface SistemaOperacional {
    void executar();
}

class Windows implements SistemaOperacional {
    @Override
    public void executar() {
        System.out.println("Executando no Windows");
    }
}

class OutroSistema implements SistemaOperacional {
    @Override
    public void executar() {
        System.out.println("Executando em outro sistema");
    }
}

class SistemaOperacionalFactory {
    public static SistemaOperacional getSistemaOperacional() {
        String os = System.getProperty("os.name");
        if (os.startsWith("Windows")) {
            return new Windows();
        } else {
            return new OutroSistema();
        }
    }
}
```

## Elegância
### Algumas características de um código com elegancia

- **Facilidade de Leitura e Compreensão:**  Um código elegante é mais legível, tornando mais fácil para outros desenvolvedores entenderem o que está acontecendo. Isso é essencial para a manutenção e colaboração em projetos de equipe.

- **Facilidade de Manutenção:** Quando o código é claro e organizado, realizar correções, adições ou atualizações se torna mais simples. Menos tempo é gasto decifrando o código existente, o que reduz a chance de introduzir novos bugs ao fazer alterações.

- **Padrões de Boas Práticas:** Escrever código de forma elegante muitas vezes segue as melhores práticas de programação. Isso promove a consistência no estilo de codificação e ajuda a garantir a conformidade com padrões aceitos pela comunidade de desenvolvimento.

- **Facilita a Depuração:** Quando algo dá errado, um código elegante é mais fácil de depurar. A clareza na estrutura do código pode ajudar a identificar e corrigir problemas mais rapidamente.

### Code smell

Alguns code smells relacionados a falta de elegancia, são: Funções/Métodos Longos  Classes ou Métodos com Muitas Responsabilidades Nomenclatura Ruim.
Um exemplo de código com esses code smells:

```java
public class ProcessData {
    public void processDataAndPrintResult(int[] data) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 0) {
                sum += data[i];
                count++;
            }
        }
        double average = (double) sum / count;
        System.out.println("Average of positive numbers: " + average);
    }
}
```
### Correção
Nesta versão refatorada, o código foi dividido em métodos menores e mais específicos. A classe DataProcessor agora tem um método para calcular a média dos números positivos e outro para imprimir o resultado. A nomenclatura também foi melhorada para refletir as responsabilidades de cada método. Isso torna o código mais legível, modular e seguindo boas práticas de nomenclatura e estruturação.

```java
public class DataProcessor {
    public double calculateAverageOfPositiveNumbers(int[] data) {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i] > 0) {
                sum += data[i];
                count++;
            }
        }

        if (count == 0) {
            return 0; /
        }

        return (double) sum / count;
    }

    public void printResult(double average) {
        System.out.println("Average of positive numbers: " + average);
    }
}
```