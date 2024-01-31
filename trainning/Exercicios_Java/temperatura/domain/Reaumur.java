package domain;

public class Reaumur implements IConversor{

    @Override
    public double converter(double celsius) {
        return celsius * 0.8;
    }
    
}
