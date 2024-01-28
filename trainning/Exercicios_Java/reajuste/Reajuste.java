package reajuste;
/*
 * Informar um saldo e imprimir o saldo com reajuste de 1%.
 */


import java.util.Scanner;

public class Reajuste {
    
    private Integer saldo;

    public static void main(String[] args) {
        Reajuste salario1 = new Reajuste(null);
        Scanner leia = new Scanner(System.in);
        System.out.println("Saldo antes:"+salario1.getSaldo());

        System.out.println("Digite um saldo para aplicar reajuste de 1%: ");
        salario1.setSaldo(leia.nextInt());

        System.out.println(salario1.getSaldo());

    }

    public Reajuste(Integer saldo) {
        this.saldo = saldo;
    }
    public Integer getSaldo() {
        return saldo;
    }
    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Integer reajuste() {
        return (int) (saldo * 0.1);        
    }
}
