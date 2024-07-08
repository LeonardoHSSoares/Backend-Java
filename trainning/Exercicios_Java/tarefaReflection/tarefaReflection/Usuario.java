package tarefaReflection;

import java.io.IOException;
import java.util.Scanner;


public class Usuario {

    private String nome;

    public Usuario() {
        
    }

    public Usuario(String nome) {
        this.nome = nome;
    }
    public Usuario(Usuario usuario) {
        this.nome = nome;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) throws IOException { this.nome = coletaNome(); }

    public String coletaNome() throws IOException {
        try (Scanner leia = new Scanner(System.in)) {
            System.out.println("Digite seu nome: ");
            setNome(leia.nextLine());
        }
        return nome;
        
    }

   
}
