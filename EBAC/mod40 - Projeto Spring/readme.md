# SimpleApp

Projeto exemplo de backend em Java utilizando Spring Boot, JPA e PostgreSQL.

## Tecnologias

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok

## Como rodar

1. **Configure o banco de dados PostgreSQL**  
   Crie um banco postgres e ajuste o usuário/senha no arquivo  
   `src/main/resources/application.properties`:
   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/ebac
   spring.datasource.username=postgres
   spring.datasource.password=admin
   ```

2. **Instale as dependências**
   ```sh
   ./mvnw clean install
   ```

3. **Execute a aplicação**
   ```sh
   ./mvnw spring-boot:run
   ```

## Estrutura principal

- `SimpleappApplication.java`: classe principal, executa um exemplo de cadastro de cliente.
- `domain/Cliente.java`: entidade JPA do cliente.
- `repository/IClienteRepository.java`: interface de repositório JPA.

## Observações

- Certifique-se de que o PostgreSQL está rodando na porta correta.
- O projeto utiliza Lombok. Se estiver usando uma IDE, instale o plugin do Lombok.

## Autor

Leonardo Soares