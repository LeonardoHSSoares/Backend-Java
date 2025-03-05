1 - private void somaNumeros(int a, int b, int c, int d, int e, int f) {}

Princípio violado: Número excessivo de parâmetros. Métodos com muitos parâmetros (idealmente, no máximo 3) ficam difíceis de entender e usar. Isso dificulta a leitura do código e aumenta a chance de erros.
Outro problema: Nomes de parâmetros ruins. a, b, c... não dizem nada sobre o que esses números representam.


2 - private void oPaiTaOn() {}

Princípio violado: Nomes não descritivos e linguagem inadequada. O nome oPaiTaOn é gíria, não diz nada sobre o que o método faz e não segue as convenções de nomenclatura de Java (camelCase).

Implementação correta:

Para implementar corretamente, precisamos saber o que o método faz. Vamos supor que ele ativa um usuário:

private void ativarUsuario(long userId) {  
    // Lógica para ativar o usuário no sistema  
}

3 - private double checaSaldoEAtualiza(long userID, double value) {}

Princípio violado: Um método deve fazer uma coisa só. O nome checaSaldoEAtualiza indica que o método faz duas coisas: checa o saldo e atualiza. Isso dificulta a leitura e o teste do código.
Outro problema: O método retorna um double, mas o nome não deixa claro o que esse double representa (o novo saldo? Um código de erro?).

Implementação correta:

Aqui, precisamos dividir o método em dois:

private boolean temSaldoSuficiente(long userID, double valor) {  
    // Lógica para checar se o usuário tem saldo suficiente  
    // Retorna true se tiver saldo, false caso contrário  
}  

private void atualizarSaldo(long userID, double valor) {  
    // Lógica para atualizar o saldo do usuário  
}  