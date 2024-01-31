package domain;

public class Kelvin implements IConversor{

    @Override
    public double converter(double celsius) {
        return celsius + 273.15;
    }
    
}
