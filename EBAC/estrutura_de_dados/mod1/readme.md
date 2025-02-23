
Neste projeto, foram implementadas quatro estruturas de dados fundamentais: Pilha (Stack), Fila FIFO (Queue), Lista Encadeada Simples (SinglyLinkedList) e Mapa de Hash (HashMapInt), todas utilizando a linguagem Java.

    1. Pilha (Stack)
    A estrutura de pilha foi implementada seguindo o princípio LIFO (Last In, First Out), com os métodos:

    push(int value): Adiciona um elemento ao topo da pilha.
    pop(): Remove e retorna o elemento do topo.
    top(): Retorna o elemento do topo sem removê-lo.
    isEmpty(): Verifica se a pilha está vazia.
    size(): Retorna o número de elementos na pilha.


    2. Fila FIFO (Queue)
    A estrutura de fila segue o princípio FIFO (First In, First Out), com os métodos:

    enqueue(int value): Adiciona um elemento ao final da fila.
    dequeue(): Remove e retorna o elemento do início da fila.
    peek(): Retorna o primeiro elemento sem removê-lo.
    isEmpty(): Verifica se a fila está vazia.
    size(): Retorna o número de elementos na fila.


    3. Lista Encadeada Simples (SinglyLinkedList)
    A lista encadeada foi implementada para permitir adição e remoção dinâmica de elementos, com os métodos:

    add(int data): Adiciona um nó no final da lista.
    remove(int data): Remove um nó específico da lista.
    contains(int data): Verifica se um valor está presente na lista.
    size(): Retorna o número de elementos na lista.


    4. Mapa de Hash (HashMapInt)
    O mapa de hash foi implementado para armazenar inteiros, utilizando Modulo Hashing com número primo e Encadeamento Separado para minimizar colisões.

Função Hash Utilizada:

    hash(key) = key % CAPACITY, onde CAPACITY é um número primo (31).
    O uso de um número primo reduz padrões de colisão e melhora a distribuição dos elementos na tabela.

Tratamento de Colisões:

    Foi adotado Encadeamento Separado, onde cada posição do array armazena uma lista encadeada de valores que compartilham o mesmo índice de hash.

Métodos Implementados:

    put(int key): Insere um valor na tabela.
    contains(int key): Verifica se um valor existe na tabela.
    remove(int key): Remove um valor da tabela, se presente.

    Função Hash Utilizada
No Mapa de Hash (HashMapInt), utilizamos a função hash:

private int hash(int key) {
    return key % CAPACITY;
}

Onde CAPACITY é um número primo (31).

Por que usei Modulo Hashing com Número Primo?
Boa distribuição dos valores:

O operador módulo (%) distribui os valores de maneira uniforme nas posições do array.
Ao usar um número primo como tamanho da tabela (CAPACITY = 31), evitamos padrões cíclicos e reduzimos colisões.

Redução de colisões:

Se CAPACITY fosse um número não primo (ex: 32 ou 30), algumas chaves poderiam cair nas mesmas posições com mais frequência, gerando mais colisões.
Exemplo:

Se CAPACITY = 32, chaves como 16, 32, 48... sempre cairiam na mesma posição (16 % 32 = 16, 32 % 32 = 0, etc.).
Com CAPACITY = 31, a distribuição é mais espalhada.
Eficiência e Simplicidade:

A operação key % CAPACITY é rápida e fácil de implementar.
Evita cálculos complexos como funções hash criptográficas.
Tratamento de Colisões: Encadeamento Separado
Se duas chaves resultarem no mesmo índice, usamos uma lista encadeada para armazená-las. Isso garante que não perderemos valores mesmo quando há colisões.

table[index].add(key);
Dessa forma, chaves diferentes que caem na mesma posição (index) são encadeadas em uma lista, permitindo armazenar múltiplos valores sem sobrescrever dados.

Conclusão
A combinação de Modulo Hashing com número primo (31) e Encadeamento Separado oferece: ✅ Distribuição uniforme dos dados
✅ Redução de colisões
✅ Eficiência computacional (O(1) na maioria dos casos)