package EBAC.mod13.Interface;

public interface ICarro {
    
    default void parar() {
        System.out.println("O "+getClass().getSimpleName()+" esta parando");
    }

    public void andar();

}
