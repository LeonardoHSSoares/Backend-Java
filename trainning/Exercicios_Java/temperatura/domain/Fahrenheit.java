package domain;

public class Fahrenheit implements IConversor{

    @Override
    public double converter(double celsius) {
        return celsius * 1.8 + 32;
    }

}
