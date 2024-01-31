package exercicio;
import java.util.Scanner;

//Desenvolva um algoritmo em Java que leia um número inteiro e imprima o seu
//antecessor e seu sucessor.

public class Exercicio {

    private Integer numero = 0;
    private Integer antecessor = 0;
    private Integer sucessor = 0;

    public Integer getAntecessor() {
        return antecessor;
    }

    public void setAntecessor(Integer antecessor) {
        this.antecessor = calculaAntecessor(numero);
    }

    public Integer getSucessor() {
        return sucessor;
    }

    public void setSucessor(Integer sucessor) {
        this.sucessor = calculaSucessor(numero);
    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        

        System.out.println("Digite um numero para saber seu sucessor e antecessor: ");

        Exercicio cliente = new Exercicio(leia.nextInt());
        leia.close();

        System.out.println(cliente.toString());


    }

    public Exercicio(Integer numero) {
        this.antecessor = calculaAntecessor(numero);
        this.numero = numero;
        this.sucessor = calculaSucessor(numero);
    }

    @Override
    public String toString() {
        return "[antecessor= "+ antecessor + "]"+"[numero=" + numero + "]"+"[sucessor=" + sucessor + "]";
    }

    public Integer getNumero() {
        return numero;
    }
    
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer calculaAntecessor(Integer numero) {
        
        return numero--;
    }

    public Integer calculaSucessor(Integer numero) {
        return numero++;
    }

}
