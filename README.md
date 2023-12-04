# TP1_SistemaEstoque
O TP1 consiste na implementação da aplicação Sistema de Estoque, com o emprego das técnicas de TDD.

Será utilizada a linguagem de programação Java juntamente com a ferramente de
automação de build Maven e o framework de testes jUnit.

## Integrantes 

| Discente | Matrícula |
|--------- | --------- |
| Andre Macedo Rodrigues Alves | 190102390  |
| Christian Fleury Alencar Siqueira | 190011602  |
| Cicero Barrozo Fernandes Filho | 190085819  |
| Leonardo Milomes Vitoriano | 201000379 |
| Thiago Siqueira Gomes | 190055294  |

## Pré-requisitos

- Java jdk-17, jre-17
- Maven >= 3.8.7 

As dependências serão instaladas através do Maven.

## Como compilar

```bash
mvn compile
```

## Como rodar os testes

```bash
mvn test
```

## Como executar o programa

```bash
mvn exec:java
```
## Como formatar o código

```bash
mvn com.spotify.fmt:fmt-maven-plugin:format
```

Referência utilizada para a formatação: https://github.com/google/google-java-format
