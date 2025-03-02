public class CaminhosMatriz {
    
    public static int contarCaminhos(int i, int j, int m, int n, String path) {
        // Se saiu dos limites, retorna 0
        if (i >= m || j >= n) return 0;
        
        // Se chegou ao destino, imprime o caminho e retorna 1
        if (i == m - 1 && j == n - 1) {
            System.out.println(path + " -> (" + i + "," + j + ")");
            return 1;
        }
        
        // Caminha para a direita e para baixo
        int caminhosDireita = contarCaminhos(i, j + 1, m, n, path + " -> (" + i + "," + j + ")");
        int caminhosBaixo = contarCaminhos(i + 1, j, m, n, path + " -> (" + i + "," + j + ")");
        
        return caminhosDireita + caminhosBaixo;
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        System.out.println("Total de caminhos: " + contarCaminhos(0, 0, m, n, ""));
    }
}
