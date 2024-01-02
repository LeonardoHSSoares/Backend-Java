package EBAC.mod13.Interface;

public class Giz implements ICaneta{
    
    public void escrever(String texto) {
        System.out.println("Escrevendo o valor "+texto+"na classe "+getClass().getSimpleName());
    }
    public String getCor() {
        return "Branco";
    }
}
