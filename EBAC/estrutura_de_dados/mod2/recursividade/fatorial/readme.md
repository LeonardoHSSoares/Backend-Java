# Cálculo de Fatorial em Java

Este projeto implementa diferentes abordagens para calcular o fatorial de um número em Java.

## Métodos Implementados

1. **Fatorial Recursivo**
   - Utiliza recursão simples para calcular o fatorial.
   - Possui complexidade O(n), mas pode gerar problemas de stack overflow para valores grandes.

2. **Fatorial com Programação Dinâmica (Top-Down - Memoization)**
   - Armazena resultados intermediários para evitar recomputação.
   - Reduz o número de chamadas recursivas, melhorando a eficiência.

3. **Fatorial com Programação Dinâmica (Bottom-Up - Tabulação)**
   - Utiliza um array para armazenar os resultados progressivamente.
   - Evita recursão, tornando a execução mais eficiente e segura para grandes valores de entrada.

## Como Executar

1. Clone ou baixe o repositório.
2. Compile o arquivo `Fatorial.java`:
   ```sh
   javac Fatorial.java
   ```
3. Execute o programa:
   ```sh
   java Fatorial
   ```

## Exemplo de Saída

```
Fatorial Recursivo: 3628800
Fatorial Top-Down: 3628800
Fatorial Bottom-Up: 3628800
```

## Melhorias Futuras

- Implementar versão iterativa sem uso de arrays para otimização de espaço.
- Comparar tempo de execução de cada abordagem.
- Adicionar testes unitários.

## Autor

Desenvolvido por Leonardo Soares.

