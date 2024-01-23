package Observer.observer.src.br.com.observer;

public class Demo {
    public static void main(String[] args) {
        Jornalista jorn = new Jornalista();
        jorn.add(new TV());
        jorn.notifyAll("Teste");
    }
}
