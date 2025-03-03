# Geração de Subconjuntos usando Backtracking

Este projeto implementa um algoritmo de **backtracking** para gerar todos os subconjuntos de um conjunto de elementos únicos.

## Descrição
O algoritmo explora todas as combinações possíveis, incluindo ou excluindo cada elemento do conjunto original, garantindo a geração completa dos subconjuntos.

### Exemplo de Entrada
```java
int[] conjunto = {1, 2, 3};
```

### Exemplo de Saída
```
Subconjuntos gerados:
[]
[3]
[2]
[2, 3]
[1]
[1, 3]
[1, 2]
[1, 2, 3]
```

## Como Executar

1. Clone ou baixe o repositório.
2. Compile o arquivo `SubconjuntosBacktrack.java`:
   ```sh
   javac SubconjuntosBacktrack.java
   ```
3. Execute o programa:
   ```sh
   java SubconjuntosBacktrack
   ```

## Complexidade
- O algoritmo possui complexidade **O(2^n)**, pois cada elemento pode ser incluído ou não em cada subconjunto.

## Melhorias Futuras
- Implementar a geração de subconjuntos iterativamente.
- Adicionar suporte para subconjuntos de tamanho específico.
- Medir o tempo de execução para diferentes tamanhos de entrada.

## Autor
Desenvolvido por Leonardo Soares.

