import java.util.HashSet;
import java.util.Set;

public class StringPermutations {
    
    public static void permute(String str) {
        permuteHelper(str.toCharArray(), 0);
    }

    private static void permuteHelper(char[] chars, int index) {
        if (index == chars.length - 1) {
            System.out.println(new String(chars));
            return;
        }

        Set<Character> seen = new HashSet<>(); // Evita permutações duplicadas
        for (int i = index; i < chars.length; i++) {
            if (seen.add(chars[i])) { // Apenas processa caracteres únicos nesta posição
                swap(chars, index, i);
                permuteHelper(chars, index + 1);
                swap(chars, index, i); // Backtrack
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String str = "LMNO";
        System.out.println("Permutações de " + str + ":");
        permute(str);
    }
}