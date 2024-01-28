package verificaPrimos;
import java.util.Scanner;

public class Ex1Primos {

    private Integer numero;

    public Ex1Primos() {
        this.numero = coletaNumero();
    }
  
    public static void main(String[] args) {
        Ex1Primos primo = new Ex1Primos();
        primo.coletaNumero();
       
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = coletaNumero();
    }

    public Integer coletaNumero() {
        Scanner leia = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        while (!leia.hasNextInt()) {
            System.out.println("Isso não é um número inteiro. Por favor, tente novamente.");
            leia.next();
            System.out.print("Digite um número inteiro: ");
            
        }
        return leia.nextInt();   
    }

   public Boolean isPrimos() {
    if (numero < 2) {
        return false;
    }
    for (int i = 2; i <= Math.sqrt(numero); i++) {
        if (numero % i == 0) {
            return false;
        }
    }
    return true;
   }
   public void informarPrimo() {
    if (isPrimo()) {
        System.out.println(numero + " é um número primo.");
    } else {
        System.out.println(numero + " não é um número primo.");
    }
}
}
