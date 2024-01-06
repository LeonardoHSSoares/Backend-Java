package EBAC.mod13.Interface;

public class CarroPasseio implements ICarro{
    
    public void andar() {
        System.out.println("O "+getClass().getSimpleName()+" esta andando rapido");
    }


}
