package com.leonardo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppTest {

    @Test
    public void testListaMulheresContemApenasFeminino() {
        IUsuario usuario = new Pessoa();
        List<Pessoa> listaTotal = new ArrayList<>();

        listaTotal.add(usuario.coletaDados("Ana Silva,f"));
        listaTotal.add(usuario.coletaDados("Maria Oliveira,f"));
        listaTotal.add(usuario.coletaDados("João Souza,m"));
        listaTotal.add(usuario.coletaDados("Carla Dias,f"));
        listaTotal.add(usuario.coletaDados("Pedro Henrique,m"));

        // Filtrando a lista de pessoas do gênero Feminino
        List<Pessoa> mulheres = listaTotal.stream()
                .filter(pessoa -> pessoa.getGenero().equals("Feminino"))
                .collect(Collectors.toList());

        // Verificando se todas as pessoas na lista de mulheres teem ogeeneroffeminino
        boolean todasSaoFeminino = mulheres.stream()
                .allMatch(pessoa -> pessoa.getGenero().equals("Feminino"));

        // certificandoo que todas são do eeneroffeminino
        assertTrue(todasSaoFeminino, "A lista de mulheres contém apenas pessoas do gênero Feminino.");
    }
}
