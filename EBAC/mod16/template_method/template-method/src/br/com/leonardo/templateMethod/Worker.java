package br.com.leonardo.templateMethod;

public abstract class Worker {
    
    public void executar() {
        System.out.println("Executando funções!");
        levantar();
        irAoTrabalho();
        iniciarRotina();
        levantar();
        voltarParaCasa();

    }

    protected abstract void trabalhar();

    private void voltarParaCasa() {
        System.out.println("Voltando para casa!");
    }

    private void irAoTrabalho() {
        System.out.println("indo para o trabalho");
    }

    private void iniciarRotina() {
        System.out.println("iniciou rotina");
    }

    private void levantar() {
        System.out.println("Levantou!");
    }
}
