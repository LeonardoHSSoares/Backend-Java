package Observer.observer.src.br.com.observer;

import java.util.ArrayList;
import java.util.List;

public class Jornalista implements Observer{

    private String titulo;
    
    public List<Observer> observers = new ArrayList<>();

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAll(String titulo) {
        this.titulo = titulo;
        for(Observer ob : this.observers) {
            ob.update(this);
        }
    }

    @Override
    public void update(Jornalista jornalista) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

  

   

   
}
