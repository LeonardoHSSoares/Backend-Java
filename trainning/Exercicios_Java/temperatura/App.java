import java.util.Scanner;

import domain.Fahrenheit;
import domain.TempContext;

public class App {

    public static void main(String[] args) {
         
    Scanner leia = new Scanner(System.in);
    System.out.println("Digite uma temperatura em Celsius: ");
    Double celsius = leia.nextDouble();
    leia.close();

    TempContext conversorFahrenheit = new TempContext(new Fahrenheit());

    System.out.println("Convertido para Fahrenheit fica:"+conversorFahrenheit.executaConversor(celsius));
    
        
    }


    
}
