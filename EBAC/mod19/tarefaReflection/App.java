package tarefaReflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class App {

    public static void main(String[] args) {

        Cliente userCliente = new Cliente();
        Produto prod = new Produto();

        // Verificar a anotação na classe Cliente
        if (userCliente.getClass().isAnnotationPresent(Tabela.class)) {
            Tabela tabelaCliente = userCliente.getClass().getAnnotation(Tabela.class);
            System.out.println("A classe Cliente está associada à tabela: " + tabelaCliente.nomeTabela());
        }

        // Verificar a anotação na classe Produto
        if (prod.getClass().isAnnotationPresent(Tabela.class)) {
            Tabela tabelaProduto = prod.getClass().getAnnotation(Tabela.class);
            System.out.println("A classe Produto está associada à tabela: " + tabelaProduto.nomeTabela());
        }

        // foreach para imprimir todas as tabelas associadas
        for (Field field : prod.getClass().getDeclaredFields()) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annot : annotations) {
                if (annot instanceof Tabela) {
                    Tabela tabelaAnnot = (Tabela) annot;
                    System.out.println(
                            "O campo " + field.getName() + " está associado à tabela: " + tabelaAnnot.nomeTabela());
                }
            }
        }

    }
}
