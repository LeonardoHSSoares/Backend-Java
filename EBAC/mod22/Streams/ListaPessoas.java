package Streams;

import java.util.ArrayList;
import java.util.List;

public class ListaPessoas {

    List<Pessoa> listaTotal;

    public ListaPessoas(List<Pessoa> listaTotal) {
        this.listaTotal = listaTotal == null ? new ArrayList<>() : listaTotal;
    }

    public List<Pessoa> getListaTotal() {
        return listaTotal;
    }

    public void setListaTotal(List<Pessoa> listaTotal) {
        this.listaTotal = listaTotal;
    }

    public void addPessoaNaLista(Pessoa pessoa) {
        listaTotal.add(pessoa);
    }

    public List<Pessoa> separaPorGenero(List<Pessoa> listaTotal) {
        List<Pessoa> listaSeparada = new ArrayList<>();
        for (Pessoa pessoa : listaTotal) {
            listaSeparada.add(pessoa);
        }
        return listaSeparada;
    }

    public void imprimirLista(List<Pessoa> lista) {
        for (Pessoa pessoa : lista) {
            System.out.println(pessoa.toString());
        }
    }
}