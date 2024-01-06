package EBAC.mod13.Interface;

public class Giz implements ICaneta{
    @Override
    public void escrever(String texto){
        System.out.println("valor do texto: "+texto+" Na classe: "+ getClass().getSimpleName());
    }
    
    public String getCor() {
        return null;
    }
}
