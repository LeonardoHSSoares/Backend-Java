package lambdas;

import java.util.List;

public interface IUsuario {
    
    Pessoa coletaDados(String entrada);
    void imprimirLista(List<Pessoa> lista);
}