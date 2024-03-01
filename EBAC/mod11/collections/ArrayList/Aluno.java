package ArrayList;

public class Aluno {

    String nome;
    int idade;
    String email;

    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", idade=" + idade + ", email=" + email + "]";
    }

    public Aluno(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    

}
