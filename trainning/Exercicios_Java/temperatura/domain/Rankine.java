package domain;

public class Rankine implements IConversor{

    @Override
    public double converter(double celsius) {
        return celsius * 1.8 + 32 + 459.67;
    }
    
}
