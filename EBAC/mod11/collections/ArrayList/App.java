package ArrayList;

import java.util.ArrayList;
import java.util.List;


public class App {

    public static void main(String[] args) {

        List<Aluno> listaAluno = new ArrayList<Aluno>();

        Aluno a = new Aluno("Leonardo", 30, "nasdar@gmail.com");
        Aluno b = new Aluno("Veronica", 35, "nascar@gmail.com");

        listaAluno.add(a);
        listaAluno.add(b);

        System.out.println(listaAluno);

    }
    

}
