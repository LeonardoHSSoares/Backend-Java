# Projeto Backend Java - EBAC (Módulo 35)

Este projeto é uma aplicação de backend desenvolvida em Java, utilizando JPA para persistência de dados, seguindo os princípios da Clean Architecture. O objetivo é demonstrar boas práticas de organização de código, separação de responsabilidades e testes automatizados.

## Tecnologias Utilizadas

- Java 11+
- Maven
- JPA (Hibernate)
- PostgreSQL
- JUnit 5

## Estrutura do Projeto

```
modulo35/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/leonardo/
│   │   │       ├── domain/         # Entidades de negócio (JPA)
│   │   │       ├── gateway/        # Interfaces (contratos) de persistência
│   │   │       ├── infrastructure/ # Implementações concretas (JPA, JDBC, etc)
│   │   │       ├── service/        # Serviços e casos de uso
│   │   └── resources/
│   │       └── META-INF/
│   │           └── persistence.xml # Configuração do JPA
│   └── test/
│       └── java/
│           └── com/leonardo/
│               ├── mock/           # Mocks para testes
│               ├── dao/            # Testes de DAOs
│               └── jpa/            # Testes de DAOs JPA
└── target/
```

## Como rodar o projeto

1. **Configure o banco de dados PostgreSQL**  
   Crie um banco de dados e ajuste as credenciais no arquivo `src/main/resources/META-INF/persistence.xml`.

2. **Execute as migrations (DDL)**  
   Utilize o script SQL disponível em `src/main/resources` ou conforme o arquivo `SQLs.sql` para criar as tabelas necessárias.

3. **Build do projeto**
   ```sh
   mvn clean install
   ```

4. **Executando os testes**
   ```sh
   mvn test
   ```

## Principais conceitos aplicados

- **Clean Architecture:** Separação clara entre domínio, gateways (contratos), infraestrutura (implementações) e serviços.
- **JPA:** Mapeamento objeto-relacional para persistência das entidades.
- **Testes automatizados:** Cobertura de testes para DAOs, serviços e regras de negócio.
- **Mock e DAO de teste:** Facilita a validação das regras sem dependência do banco.

## Pastas importantes

- `domain`: Entidades do sistema (ex: ClienteJPA, ProdutoJPA, VendaJPA).
- `gateway`: Interfaces de persistência (ex: IClienteJPAGateway, IProdutoJPAGateway).
- `infrastructure`: Implementações concretas das interfaces de gateway.
- `service`: Serviços de negócio e casos de uso.
- `test`: Testes automatizados (JUnit 5).

## Contato

Projeto desenvolvido para fins educacionais no curso de Backend Java da EBAC.  
Autor: Leonardo Soares