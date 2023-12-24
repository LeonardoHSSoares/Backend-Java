package EBAC.mod11.collections.ArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * ExemploArrayList
 */
public class ExemploArrayList {

    List<Aluno> lista = new ArrayList<Aluno>();
    Aluno a = new Aluno("Leonardo", 30, "Backend Java");@Override

    lista.add(a);

}

public String toString() {
        return "ExemploArrayList [lista=" + lista + "]";
    }