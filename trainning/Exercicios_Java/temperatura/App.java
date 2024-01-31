import java.util.Scanner;

import domain.Fahrenheit;
import domain.Kelvin;
import domain.Rankine;
import domain.Reaumur;
import domain.TempContext;

public class App {

    public static void main(String[] args) {
         
    Scanner leia = new Scanner(System.in);
    System.out.println("Digite uma temperatura em Celsius: ");
    Double celsius = leia.nextDouble();
    leia.close();

    TempContext conversorFahrenheit = new TempContext(new Fahrenheit());
    TempContext conversorKelvin = new TempContext(new Kelvin());
    TempContext conversorReaumur = new TempContext(new Reaumur());
    TempContext conversorRankine = new TempContext(new Rankine());


    System.out.println("Conversão para Fahrenheit: "+conversorFahrenheit.executaConversor(celsius));
    System.out.println("Conversão para Kelvin: "+conversorKelvin.executaConversor(celsius));
    System.out.println("Conversão para Reaumur: "+conversorReaumur.executaConversor(celsius));
    System.out.println("Conversão para Rankine: "+conversorRankine.executaConversor(celsius));
    
        
    }


    
}
