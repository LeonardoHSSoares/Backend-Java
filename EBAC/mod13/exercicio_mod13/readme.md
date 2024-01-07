Sistema de Gerenciamento de Pessoas - EBAC Módulo 13

Este projeto do EBAC Módulo 13 é uma aplicação Java simples que demonstra o uso de classes abstratas e herança. Ele define uma estrutura básica para gerenciar informações de pessoas, diferenciando entre pessoas físicas e jurídicas.
Estrutura do Projeto

O projeto contém três classes principais no pacote EBAC.mod13.exercicio_mod13:


1. Pessoa (Classe Abstrata)

    Descrição: Esta é uma classe abstrata que serve como base para Fisica e Juridica. Ela define propriedades comuns como nome, idade e altura.
    Métodos Abstratos: pegarIdentificador() - Deve ser implementado pelas subclasses para retornar um identificador único (CPF ou CNPJ).

2. Fisica (Subclasse de Pessoa)

    Descrição: Representa uma pessoa física.
    Propriedades Específicas: cpf (String).
    Métodos: Inclui métodos para obter e definir o CPF.

3. Juridica (Subclasse de Pessoa)

    Descrição: Representa uma pessoa jurídica.
    Propriedades Específicas: cnpj (String).
    Métodos: Inclui métodos para obter e definir o CNPJ.

Funcionalidades

    Abstração: A classe Pessoa fornece uma abstração comum com propriedades básicas e um método abstrato pegarIdentificador.
    Herança: Fisica e Juridica herdam de Pessoa e implementam o método abstrato pegarIdentificador.
    Polimorfismo: Através de polimorfismo, objetos de Fisica e Juridica podem ser tratados como objetos de Pessoa, mas com comportamentos específicos.

Como Executar

    Certifique-se de que o Java está instalado em sua máquina.
    Compile os arquivos Java em seu ambiente de desenvolvimento ou usando um compilador de linha de comando.
    Execute a classe principal que contém o método main. Neste projeto, o método main está na classe Pessoa e serve principalmente para fins de teste.

Notas Adicionais

    O método main na classe Pessoa é apenas para fins de teste e demonstração. Em um aplicativo real, você pode querer separar a lógica de teste em uma classe específica para testes.