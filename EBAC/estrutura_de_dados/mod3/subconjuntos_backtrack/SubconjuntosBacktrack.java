/*
 * O primeiro exercício requer calcular todos os subconjuntos de n elementos de um conjunto dado.
 */

import java.util.ArrayList;
import java.util.List;

public class SubconjuntosBacktrack {
    
    public static void gerarSubconjuntos(int[] nums, int indice, List<Integer> subconjuntoAtual, List<List<Integer>> resultado) {
        if (indice == nums.length) {
            resultado.add(new ArrayList<>(subconjuntoAtual));
            return;
        }
        
        // Não incluir o elemento atual
        gerarSubconjuntos(nums, indice + 1, subconjuntoAtual, resultado);
        
        // Incluir o elemento atual
        subconjuntoAtual.add(nums[indice]);
        gerarSubconjuntos(nums, indice + 1, subconjuntoAtual, resultado);
        
        // Remover o elemento adicionado (backtrack)
        subconjuntoAtual.remove(subconjuntoAtual.size() - 1);
    }
    
    public static List<List<Integer>> gerarTodosSubconjuntos(int[] nums) {
        List<List<Integer>> resultado = new ArrayList<>();
        gerarSubconjuntos(nums, 0, new ArrayList<>(), resultado);
        return resultado;
    }
    
    public static void main(String[] args) {
        int[] conjunto = {1, 2, 3};
        List<List<Integer>> subconjuntos = gerarTodosSubconjuntos(conjunto);
        
        System.out.println("Subconjuntos gerados:");
        for (List<Integer> s : subconjuntos) {
            System.out.println(s);
        }
    }
}

