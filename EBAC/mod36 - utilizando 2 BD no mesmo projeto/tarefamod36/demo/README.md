# Projeto Backend Java - EBAC (Módulo 36)

Este projeto é uma evolução do módulo 35, agora com suporte a múltiplos bancos de dados utilizando apenas JPA. Toda a camada JDBC foi removida e, na camada de infraestrutura, foram adicionadas classes abstratas para facilitar a implementação de DAOs para diferentes bancos de dados.

## Principais mudanças em relação ao módulo 35

- **Remoção completa da camada JDBC:**  
  Todo o código relacionado ao JDBC foi eliminado do projeto, tornando a persistência 100% baseada em JPA.
- **Infraestrutura com DAOs abstratos para múltiplos bancos:**  
  Foram criadas classes abstratas na camada `infrastructure/dao/generic` para cada banco de dados (ex: `GenericJPADB1DAO`, `GenericJPADB2DAO`, `GenericJPADB3DAO`). Cada DAO concreto herda da respectiva classe abstrata, facilitando a troca e o uso de múltiplos bancos no mesmo projeto.

## Estrutura do Projeto

```
modulo36/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/leonardo/
│   │   │       ├── domain/         # Entidades de negócio (JPA)
│   │   │       ├── gateway/        # Interfaces (contratos) de persistência
│   │   │       ├── infrastructure/ # Implementações concretas (JPA, DAOs abstratos por banco)
│   │   │       ├── service/        # Serviços e casos de uso
│   │   └── resources/
│   │       └── META-INF/
│   │           └── persistence.xml # Configuração do JPA
│   └── test/
│       └── java/
└── target/
```

## Tecnologias Utilizadas

- Java 11+
- Maven
- JPA (Hibernate)
- PostgreSQL, MySQL (exemplo de múltiplos bancos)
- JUnit 5

## Como rodar o projeto

1. **Configure os bancos de dados**  
   Crie os bancos necessários (ex: PostgreSQL, MySQL) e ajuste as credenciais no arquivo `src/main/resources/META-INF/persistence.xml`.

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
- **JPA:** Mapeamento objeto-relacional para persistência das entidades, incluindo relacionamentos entre tabelas.
- **DAOs abstratos para múltiplos bancos:** Facilita a implementação e manutenção de DAOs para diferentes bancos de dados.
- **Testes automatizados:** Cobertura de testes para DAOs, serviços e regras de negócio.

## Pastas importantes

- `domain`: Entidades do sistema (ex: ClienteJPA, ProdutoJPA, VendaJPA, ProdutoQuantidadeJPA).
- `gateway`: Interfaces de persistência (ex: IClienteJPAGateway, IProdutoJPAGateway).
- `infrastructure`: Implementações concretas das interfaces de gateway e DAOs abstratos por banco.
- `service`: Serviços de negócio e casos de uso.
- `test`: Testes automatizados (JUnit 5).

## Contato

Projeto desenvolvido para fins educacionais no curso de Backend Java da EBAC.  
Autor: Leonardo Soares