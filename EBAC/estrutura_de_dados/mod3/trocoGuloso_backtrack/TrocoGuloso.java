/*
 * a tarefa aborda a implementação do algoritmo guloso para calcular o troco com o menor número de moedas.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TrocoGuloso {

    public static Map<Integer, Integer> calcularTroco(int[] moedas, int valor) {
        Arrays.sort(moedas);
        Map<Integer, Integer> troco = new HashMap<>();

        for (int i = moedas.length - 1; i >= 0; i--) {
            int moeda = moedas[i];
            int qtd = valor / moeda;
            if (qtd > 0) {
                troco.put(moeda, qtd);
                valor -= qtd * moeda;
            }
        }

        return troco;
    }

    public static void main(String[] args) {
        int[] moedas = { 1, 5, 10, 25, 50 }; // Moedas em centavos (ex: 1 real = 100 centavos)
        int valor = 63; // Exemplo: 63 centavos

        Map<Integer, Integer> resultado = calcularTroco(moedas, valor);

        System.out.println("Troco calculado:");
        for (Map.Entry<Integer, Integer> entry : resultado.entrySet()) {
            System.out.println("Moeda: " + entry.getKey() + " centavos - Quantidade: " + entry.getValue());
        }
    }
}
