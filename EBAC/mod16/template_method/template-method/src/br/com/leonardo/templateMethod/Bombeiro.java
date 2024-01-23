package br.com.leonardo.templateMethod;

public class Bombeiro extends Worker{

    @Override
    protected void trabalhar() {
       System.out.println("Trabalhando como Bombeiro");
    }
    
}
