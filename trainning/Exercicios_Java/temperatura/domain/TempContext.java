package domain;

public class TempContext {
    
    private IConversor conversor;

    public TempContext(IConversor conversor) {
        this.conversor = conversor;
    }

    public Double executaConversor(Double celsius) {
        return conversor.converter(celsius);
    }
    

}
