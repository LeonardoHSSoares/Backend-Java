package EBAC.mod13.Interface;

public class ClasseTeste {
    
    public static void main(String args[]) {
        ICaneta caneta = new CanetaEsferografica();
        caneta.escrever("Ola mundo!");
        System.out.println(caneta.getCor());

        ICaneta giz = new Giz();
        giz.escrever("Ola Mundo!");
        System.out.println(giz.getCor());

        ICaneta lapis = new Lapis();
        lapis.escrever("Ola Mundo!");
        System.out.println(lapis.getCor());
    }

}
