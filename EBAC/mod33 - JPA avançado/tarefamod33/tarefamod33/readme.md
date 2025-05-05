# 🚗 Projeto JPA - Cadastro de Carros, Marcas e Acessórios

Este projeto demonstra o uso de **Java com JPA (Jakarta Persistence API)** e **PostgreSQL** para modelagem de entidades utilizando **herança**, **relacionamentos entre tabelas** e uma **camada DAO genérica** para persistência de dados.

---

## 📚 Funcionalidades

- Cadastro de **Carros**, **Marcas** e **Acessórios**
- Relacionamentos entre entidades:
  - `Carro` ↔ `Marca` (**ManyToOne**)
  - `Carro` ↔ `Acessorio` (**ManyToMany**)
- Uso de **herança** com uma superclasse `Veiculo`
- DAO genérico reutilizável (`GenericDAO`)
- Testes simples de persistência usando a API do JPA

---

## 🧱 Estrutura de Entidades

```plaintext
    Veiculo (abstract)
    │
    ├── Carro
    │    ├── Marca (ManyToOne)
    │    └── Acessorio (ManyToMany)

## 🛠 Tecnologias

Java 17+

JPA (Jakarta Persistence)

Hibernate (implementação JPA)

PostgreSQL

JDBC Driver PostgreSQL

VS Code / IntelliJ

## 🚀 Como Executar

1. Clone o projeto

git clone https://github.com/seuusuario/nome-do-repo.git
cd nome-do-repo

2. Configure o banco PostgreSQL
Crie um banco de dados chamado jpa_veiculos

Certifique-se de ter um usuário com acesso (ex: usuario: postgres, senha: postgres)

Atualize os dados no arquivo persistence.xml

3. Arquivo persistence.xml

## xml

<persistence-unit name="exemploPU">
  <class>com.leonardo.domain.Veiculo</class>
  <class>com.leonardo.domain.Carro</class>
  <class>com.leonardo.domain.Marca</class>
  <class>com.leonardo.domain.Acessorio</class>
  <properties>
    <property name="jakarta.persistence.jdbc.driver" value="org.postgresql.Driver"/>
    <property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/jpa_veiculos"/>
    <property name="jakarta.persistence.jdbc.user" value="postgres"/>
    <property name="jakarta.persistence.jdbc.password" value="postgres"/>
    <property name="jakarta.persistence.schema-generation.database.action" value="create"/>
    <property name="hibernate.show_sql" value="true"/>
  </properties>
</persistence-unit>

## 🧪 Testes

A classe AppDAOTest realiza:

Criação e persistência de Marca

Criação de Acessório

Criação de Carro com Marca e Acessórios associados

Consulta e impressão dos dados via DAO

## 📁 Estrutura do Projeto

    src/
    ├── com/leonardo/domain/
    │   ├── Veiculo.java
    │   ├── Carro.java
    │   ├── Marca.java
    │   └── Acessorio.java
    │
    ├── com/leonardo/dao/
    │   ├── GenericDAO.java
    │   └── GenericDAOImpl.java
    │
    ├── AppDAOTest.java
    └── META-INF/persistence.xml

## ✍️ Autor
Leonardo Soares
Desenvolvedor Back-End Java | Focado em Arquiteturas Limpas e Boas Práticas
