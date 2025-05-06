# Exemplomod37

Este é um projeto Java simples criado para demonstrar o uso do Maven como gerenciador de dependências.

## Descrição

O projeto contém uma aplicação básica que imprime "Hello World!" no console e inclui um exemplo de teste unitário utilizando o framework JUnit 5.

## Estrutura do Projeto

- **`src/main/java`**: Contém o código-fonte principal.
- **`src/test/java`**: Contém os testes unitários.
- **`pom.xml`**: Arquivo de configuração do Maven, onde as dependências e plugins são definidos.

## Dependências

As seguintes dependências foram utilizadas neste projeto:

- **Spring JPA (versão 2.0.8)**: Framework para persistência de dados e integração com bancos de dados.
  ```xml
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jpa</artifactId>
    <version>2.0.8</version>
  </dependency>
  ```

- **JUnit 5 Engine (versão 5.0.0-ALPHA)**: Framework para execução de testes unitários.
  ```xml
  <dependency>
    <groupId>org.junit</groupId>
    <artifactId>junit5-engine</artifactId>
    <version>5.0.0-ALPHA</version>
  </dependency>
  ```
## Requisitos

Java 17 ou superior: O projeto foi configurado para compilar com a versão 17 do Java.

Maven: Certifique-se de ter o Maven instalado para compilar e executar o projeto.

## Como Executar
1.Clone este repositório:

git clone <URL_DO_REPOSITORIO>
cd exemplomod37

2.Compile o projeto:

mvn compile

3.Execute a aplicação:

mvn exec:java -Dexec.mainClass="com.leonardo.App"

Execute os testes:

mvn test

Autor
Leonardo


