# Exemplo Vendas Mod25

Este projeto é um exemplo de aplicação Java para gerenciamento de vendas, desenvolvido como parte do curso da EBAC. Ele utiliza conceitos de programação orientada a objetos, persistência de dados em memória e testes unitários com JUnit.

## Funcionalidades

O projeto implementa as seguintes funcionalidades:

### Gerenciamento de Clientes
- Cadastro, consulta, alteração e exclusão de clientes.

### Gerenciamento de Produtos
- Cadastro, consulta, alteração e exclusão de produtos.

### Gerenciamento de Vendas
- Criação de vendas, adição e remoção de produtos, finalização e cancelamento de vendas.

### Persistência em Memória
- Utiliza um singleton (`SingletonMap`) para simular um banco de dados em memória.

### Testes Unitários
- Testes para DAOs e serviços utilizando JUnit.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação principal.
- **JUnit 4.13.2**: Framework para testes unitários.
- **Maven**: Gerenciador de dependências e build.

## Como Executar

1. Certifique-se de ter o Java 17 e o Maven instalados em sua máquina.
2. Clone este repositório:
   ```bash
 git clone

3. Navegue até o diretório do projeto:
    ```bash
 cd exemplo_vendas_mod25

4. Compile o projeto:
 mvn clean install

5. Execute os testes
 mvn test


## Testes

Os testes estão localizados no diretório src/test/java/com/leonardo/testes. Eles cobrem as funcionalidades principais do projeto, incluindo:

Testes para DAOs (ClienteDAOTest, ProdutoDAOTest, VendaDAOTest).

Testes para serviços (ClienteServiceTest, ProdutoServiceTest).

Teste de integração com todos os testes (AllTests).

# Estrutura de Classes

## Classes de Domínio

Cliente: Representa os dados de um cliente.

Produto: Representa os dados de um produto.

Venda: Representa uma venda, contendo
cliente, produtos e status.

## DAO (Data Access Object)

ClienteDAO: Implementação para persistência de clientes.

ProdutoDAO: Implementação para persistência de produtos.

VendaDAO: Implementação para persistência de vendas.

## Serviços

ClienteService: Regras de negócio para clientes.

ProdutoService: Regras de negócio para produtos.

## Exceções

TipoChaveNaoEncontradaException: Exceção lançada quando uma chave primária não é encontrada.

# Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

# Licença
Este projeto é apenas para fins educacionais e não possui uma licença específica.

# Autor: Leonardo Soares
Curso: Backend Java - EBAC ```
