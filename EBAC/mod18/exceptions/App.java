import java.io.PrintStream;

public class App {

    public static void main(String args[]) {
    
        System.out.println("Excessão 1");
        saqueRuntimeException(300d);

    }

    public static void saqueRuntimeException(double valor) {
        if (valor < 400) {
            IllegalArgumentException erro = 
            new IllegalArgumentException("Valor nao disponivel para saque");

            throw erro;
        }else{
            System.out.println("Valor retirado da conta: "+valor);
        }
    }  
    public static void runtimeException() {
        App.saqueRuntimeException(300d);
    }
}
