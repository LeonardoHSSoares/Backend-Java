import java.util.Scanner;


public class Reajuste {

    private Double saldo;

    public static void main(String[] args) {
        Reajuste salario1 = new Reajuste(null);
        Scanner leia = new Scanner(System.in);
        System.out.println("Saldo antes:"+salario1.getSaldo());
        

        System.out.println("Digite um saldo para aplicar reajuste de 1%: ");
        salario1.setSaldo(leia.nextDouble());

        System.out.println(salario1.reajuste()+salario1.getSaldo());

    }

    public Reajuste(Double saldo) {
        this.saldo = saldo;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double reajuste() {
        return saldo * 0.1;        
    }
}
