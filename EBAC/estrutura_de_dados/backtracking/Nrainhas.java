//Dado um tabuleiro de tamanho NxN, devemos colocar N rainhas no tabuleiro de forma
// que nenhuma delas se ataque.
// Ex. N = 4

// 0 1 0 0
// 0 0 0 1
// 1 0 0 0
// 0 0 1 0

public class Nrainhas {
    
    public static boolean resolvendoRainhas(int[][] tab, int n) {
        
        if (n == 0) {
            return  true;
        }

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (temAtaque(i,j,tab)) {
                    continue;
                }

                tab[i][j] = 1;

                if (resolvendoRainhas(tab, n-1)) {
                    return true;
                }

                tab[i][j] = 0;
            }
        }

        
        return false;
    }

    private static boolean temAtaque(int x, int y, int[][] tab) {

        for (int j = 0; j < tab.length; j++){

            if (tab[x][j] == 1) {
                return true;
            }
        }
        
        for (int i = 0; i < tab.length; i++) {
            if (tab[i][y] == 1) {
                return true;
            }
        }

        


        return false;
        
    }

    public static void imprimeMatiz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matriz = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };

        imprimeMatiz(matriz);
    }
}
