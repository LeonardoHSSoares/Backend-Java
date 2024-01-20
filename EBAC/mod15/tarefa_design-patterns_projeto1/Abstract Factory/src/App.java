

import br.com.leonardo.fabricadecarros.carros.ICarro;
import br.com.leonardo.fabricadecarros.carros.SUV;

public class App {
    public static void main(String[] args) {
    
        ICarro crvCarro = new SUV("CR-V", 2020);
        crvCarro.exibirInfo();
    }
    
}
