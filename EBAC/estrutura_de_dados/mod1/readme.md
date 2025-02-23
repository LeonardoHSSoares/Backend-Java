
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