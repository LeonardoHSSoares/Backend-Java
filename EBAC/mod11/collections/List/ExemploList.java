package List;
import java.util.ArrayList;
import java.util.List;

public class ExemploList {
    public static void main(String[] args) {
       List<String> lista = new ArrayList<String>();

       lista.add("Leonardo");
       lista.add("Veronica");
       lista.add("Sophia");

       System.out.println(lista);

       System.out.println("Segundo endereço:");
       System.out.println(lista.get(1));

       System.out.println(lista.remove(1));
       System.out.println("removeu segundo endereço: ");
       System.out.println(lista);
    }
}
