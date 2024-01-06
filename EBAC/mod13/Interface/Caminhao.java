package EBAC.mod13.Interface;

public class Caminhao implements ICarro{

    
    public void andar() {
        System.out.println("O "+getClass().getSimpleName()+" esta andando");
    }

    public void parar() {
        System.out.println("O caminhao esta parando...");
    }
    


}
