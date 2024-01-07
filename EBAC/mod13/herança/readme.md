    Abstração: 
    A classe Pessoa fornece uma abstração comum com propriedades básicas e um método abstrato pegarIdentificador.

    Herança: 
    Fisica e Juridica herdam de Pessoa e implementam o método abstrato pegarIdentificador.
    
    Polimorfismo: 
    Através de polimorfismo, objetos de Fisica e Juridica podem ser tratados como objetos de Pessoa, mas com comportamentos específicos.

1. Pessoa (Classe Abstrata)

    Descrição: Esta é uma classe abstrata que serve como base para Fisica e Juridica. Ela define propriedades comuns como nome, idade e altura.
    Métodos Abstratos: pegarIdentificador() - Deve ser implementado pelas subclasses para retornar um identificador único (CPF ou CNPJ).

2. Fisica (Subclasse de Pessoa) Classe Concreta

    Descrição: Representa uma pessoa física.
    Propriedades Específicas: cpf (String).
    Métodos: Inclui métodos para obter e definir o CPF.

3. Juridica (Subclasse de Pessoa) Classe concreta

    Descrição: Representa uma pessoa jurídica.
    Propriedades Específicas: cnpj (String).
    Métodos: Inclui métodos para obter e definir o CNPJ.