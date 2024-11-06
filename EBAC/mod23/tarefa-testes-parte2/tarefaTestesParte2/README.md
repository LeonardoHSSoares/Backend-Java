
# Sistema de Gerenciamento de Clientes e Contratos

Este programa é uma aplicação simples em Java que demonstra o uso de conceitos como **injeção de dependência**, **mocking** e **testes unitários**. O sistema contém serviços para gerenciar operações de clientes e contratos, com uma implementação mockada para facilitar os testes sem dependência de banco de dados.

## Estrutura do Projeto

O projeto é dividido nas seguintes principais partes:

1. **DAO (Data Access Object)**: Representa a camada de acesso aos dados.
2. **Service**: Contém a lógica de negócios do sistema.
3. **Mocks**: Simula comportamentos para testes.
4. **Testes Unitários**: Verifica a funcionalidade do sistema de forma isolada.

### Camada DAO

As interfaces e implementações de DAO fornecem os métodos necessários para a manipulação de dados (salvar, atualizar, excluir e consultar). Para fins de testes, um mock da classe `ClienteDAO` foi implementado.

- **IClienteDAO**: Interface com métodos de persistência.
- **ClienteDAO**: Implementação real da interface, mas com exceções para simular a falta de configuração do banco de dados.
- **ClienteDAOMock**: Mock da classe `IClienteDAO`, retornando respostas simuladas para cada operação.

### Camada Service

A camada de serviço contém as lógicas de negócios para os clientes e contratos. Ela interage com os DAOs e permite a execução das operações de salvar, atualizar, excluir e consultar.

- **IContratoService**: Interface que define os métodos que o serviço de contrato precisa implementar.
- **ContratoService**: Implementação real da interface `IContratoService` que chama os métodos do `IClienteDAO` para realizar operações de negócio.

- **ClienteService**: Serviço para gerenciar operações relacionadas a clientes. Ele também chama os métodos do `IClienteDAO` e oferece as funcionalidades de salvar, atualizar, excluir e consultar.

### Mock para Testes

A classe `ContratoServiceMock` é uma versão mockada da interface `IContratoService`. Ela simula as operações de contrato, permitindo que outras partes do sistema possam ser testadas sem interagir com o banco de dados.

- **ContratoServiceMock**: Fornece respostas simuladas para os métodos de `salvar`, `atualizar`, `excluir` e `consultar`.

### Testes Unitários

Testes unitários foram implementados para verificar o comportamento de cada camada do sistema. Usamos o **JUnit** para garantir que os métodos dos serviços e DAOs funcionem corretamente.

- **ClienteServiceTest**: Testes para a classe `ClienteService`, verificando as operações de salvar, atualizar, excluir e consultar, com testes tanto para o caso de sucesso usando mocks quanto para a falha usando `ClienteDAO`.
- **ContratoServiceTest**: Testes para a classe `ContratoService`, similar ao `ClienteServiceTest`, mas para o contexto de contratos. Também utiliza mocks e simula exceções para testar falhas.

## Como Executar

### Requisitos

- JDK 11 ou superior
- IDE como IntelliJ IDEA ou VS Code (opcional)

### Compilação e Execução

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/LeonardoHSSoares/Backend-Java/tree/main/EBAC/mod23/tarefa-testes-parte2/tarefaTestesParte2.git
   cd Backend-Java/tree/main/EBAC/mod23/tarefa-testes-parte2/tarefaTestesParte2
   ```

2. **Compile o projeto**:
   Se você estiver usando Maven, execute o seguinte comando:
   ```bash
   mvn clean install
   ```

3. **Execute o programa**:
   Execute a classe `App.java` para ver o sistema em ação:
   ```bash
   mvn exec:java -Dexec.mainClass="main.App"
   ```

### Rodando Testes Unitários

Para rodar os testes unitários, basta executar:
```bash
mvn test
```

Isso irá executar todos os testes definidos nas classes de testes como `ClienteServiceTest` e `ContratoServiceTest`.

## Explicação do Fluxo de Execução

1. **Execução do Programa**:
   Quando o programa é executado, ele inicia criando objetos de serviço com os DAOs mockados (`ClienteDAOMock`) e reais (`ClienteDAO`). Ele então tenta executar operações de salvar, atualizar, excluir e consultar em ambos os serviços (`ClienteService` e `ContratoService`).

2. **Mocking e Testes**:
   Durante os testes, usamos o **ClienteDAOMock** para simular as operações de banco de dados e validar se a lógica dos serviços funciona corretamente. Além disso, são testadas as exceções quando os métodos do `ClienteDAO` são chamados sem a devida configuração de banco de dados.

3. **Testes Unitários**:
   Os testes garantem que:
   - Os métodos `salvar`, `atualizar`, `excluir` e `consultar` funcionam corretamente quando usados com um mock.
   - O programa lança exceções apropriadas quando a configuração do banco de dados não está presente.

### Fluxo do Sistema

1. O `App.java` executa a classe `ClienteService` e `ContratoService` passando `ClienteDAOMock` ou `ClienteDAO` para testar os comportamentos.
2. Quando usando `ClienteDAOMock`, as operações de salvar, atualizar, excluir e consultar são simuladas e não interagem com um banco de dados real.
3. Quando usando `ClienteDAO` sem configuração, as operações geram uma `UnsupportedOperationException`.

## Exemplo de Saída

Se você rodar o programa `App.java` com o mock:

```java
Resultado ClienteService (Mock): Mock - Sucesso ao salvar
Resultado ContratoService (Mock): Mock - Sucesso ao salvar
```

Se rodar com o `ClienteDAO` real, sem configuração de banco de dados:

```java
Erro: Sem config à base de dados
```

## Conclusão

Este projeto serve como um exemplo de como utilizar **injeção de dependência**, **mocking**, e **testes unitários** para testar lógicas de negócios em uma aplicação Java. A abordagem facilita a manutenção do código, o isolamento de testes e a compreensão dos fluxos de execução do sistema.
```

### Explicação do `README.md`

1. **Estrutura do Projeto**: Explica a organização das classes e interfaces.
2. **Como Executar**: Detalha os passos para compilar e rodar o projeto.
3. **Fluxo de Execução**: Descreve como o sistema funciona quando executado e testado, incluindo os testes com mocks.
4. **Exemplo de Saída**: Mostra exemplos de saídas de execução dependendo do uso de mocks ou da implementação real.
5. **Conclusão**: Resume o propósito do projeto e o uso das técnicas apresentadas.

Esse `README` serve como guia completo para quem deseja entender e executar o projeto.