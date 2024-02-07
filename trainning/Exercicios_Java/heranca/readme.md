    Funcionario é a classe base que contém nome, salário e métodos para adicionar aumento e calcular o ganho anual.
    
    Assistente herda de Funcionario e adiciona um número de matrícula. O método exibeDados() é sobrescrito para exibir também o número de matrícula.
    
    Tecnico e Administrativo herdam de Assistente e sobrescrevem o método ganhoAnual() para calcular o ganho anual com base nas especificidades de cada tipo de assistente.
    Na classe Main, é feito um teste das classes criadas.