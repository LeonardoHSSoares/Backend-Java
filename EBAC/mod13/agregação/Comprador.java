package EBAC.mod13.agregação;

public class Comprador {
    
    private Double verba;

    public Double getVerba() {
        return verba;
    }
    public void setVerba(Double verba) {
        this.verba = verba;
    }
    public void comprar() {
        System.out.println("Vendido!");
    }

}
