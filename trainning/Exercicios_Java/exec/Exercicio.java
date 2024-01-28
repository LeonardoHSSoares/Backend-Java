import java.util.Scanner;

public class Exercicio {

    private Integer numero;

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        Exercicio cliente = new Exercicio(null);

        System.out.println("Digite um numero para saber seu sucessor e antecessor: ");

        cliente.setNumero(leia.nextInt());
        leia.close();
        
        Integer antecessor = cliente.calculaAntecessor(cliente.getNumero());
        Integer sucessor = cliente.calculaSucessor(cliente.getNumero());

        System.out.println("Antecessor: "+ antecessor);
        System.out.println("Numero Digitado: "+ cliente.getNumero());
        System.out.println("Sucessor: "+ sucessor);

    }

    public Exercicio(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }
    
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer calculaAntecessor(Integer numero) {
        
        return numero-1;
    }

    public Integer calculaSucessor(Integer numero) {
        return numero+1;
    }

}
