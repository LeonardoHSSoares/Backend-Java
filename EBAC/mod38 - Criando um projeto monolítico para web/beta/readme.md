# Projeto Monolítico EBAC - Sistema de Cadastro de Clientes

Este projeto é um sistema web monolítico desenvolvido em Java, utilizando JSF para a camada de apresentação, JPA/Hibernate para persistência e Maven para gerenciamento de dependências. O objetivo é gerenciar clientes, permitindo operações de cadastro, consulta, alteração e exclusão.

## Estrutura do Projeto

```
demo/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/leonardo/
│   │   │       ├── controller/      # Controllers JSF
│   │   │       ├── dao/             # DAOs genéricos e específicos
│   │   │       ├── domain/          # Entidades JPA
│   │   │       ├── exceptions/      # Exceções customizadas
│   │   │       └── service/         # Camada de serviço
│   │   ├── resources/
│   │   │   └── META-INF/persistence.xml # Configuração JPA
│   │   └── webapp/
│   │       ├── index.xhtml
│   │       ├── cliente/list.xhtml
│   │       └── WEB-INF/
│   │           ├── beans.xml
│   │           ├── faces-config.xml
│   │           ├── jboss-web.xml
│   │           └── web.xml
│   └── test/
│       └── java/com/leonardo/ClienteTest.java # Testes unitários
└── target/
    └── demo.war
```

## Principais Tecnologias

- **Java 8+**
- **JSF (PrimeFaces)**
- **JPA (Hibernate)**
- **PostgreSQL**
- **Maven**

## Configuração do Ambiente

1. **Pré-requisitos**
   - JDK 8 ou superior
   - Maven 3.6+
   - PostgreSQL
   - IDE (VS Code, Eclipse, IntelliJ)

2. **Banco de Dados**
   - Crie um banco chamado `ebac_demo` no PostgreSQL.
   - Configure usuário e senha conforme o arquivo `src/main/resources/META-INF/persistence.xml`.

3. **Configuração JPA**
   - O arquivo `persistence.xml` já está configurado para PostgreSQL.
   - Ajuste as propriedades de conexão conforme necessário.

4. **Dependências**
   - Todas as dependências estão declaradas no `pom.xml`.
   - Para baixar e instalar, execute:
     ```
     mvn clean install
     ```

## Executando o Projeto

1. **Build**
   ```
   mvn clean package
   ```
   O arquivo `.war` será gerado em `target/demo.war`.

2. **Deploy**
   - Faça o deploy do `.war` em um servidor compatível com Java EE (Wildfly, Tomcat, JBoss).

3. **Acesso**
   - Acesse via navegador: `http://localhost:8080/demo`
   - Tela inicial: `index.xhtml`
   - Listagem de clientes: `cliente/list.xhtml`

## Estrutura das Camadas

- **Controller:** Gerencia a interação entre a interface JSF e o backend.
- **Service:** Regras de negócio e validações.
- **DAO:** Persistência e consultas ao banco de dados.
- **Domain:** Entidades JPA que representam as tabelas do banco.
- **Exceptions:** Tratamento de erros específicos do domínio.

## Testes

- Os testes unitários estão em `src/test/java/com/leonardo/ClienteTest.java`.
- Para executar:
  ```
  mvn test
  ```

## Principais Arquivos

- `pom.xml`: Gerenciamento de dependências.
- `persistence.xml`: Configuração do JPA/Hibernate.
- `Cliente.java`: Entidade principal do sistema.
- `ClienteDAO.java`: DAO específico para Cliente.
- `ClienteController.java`: Controller JSF para Cliente.
- `ClienteTest.java`: Testes unitários da entidade Cliente.

## Temas e Bibliotecas JSF

- PrimeFaces para componentes visuais.
- all-themes para temas JSF.

## Observações

- O projeto segue o padrão MVC.
- O deploy pode ser feito em qualquer servidor Java EE.
- Para dúvidas ou sugestões, entre em contato com o autor.

---

**Autor:** Leonardo Soares
