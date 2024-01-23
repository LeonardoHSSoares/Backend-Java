package Observer.observer.src.br.com.observer;

public class TV implements Observer{

    public void update(Subject subject) {
        System.out.println("Recebendo a noticia via TV"+subject.toString());
    }
}
