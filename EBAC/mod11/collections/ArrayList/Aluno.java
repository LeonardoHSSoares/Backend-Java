package EBAC.mod11.collections.ArrayList;

public class Aluno {

    private String nome;
    private Integer idade;
    private String curso;

    public String getNome(String nome) {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    public Aluno(String nome, Integer idade, String curso) {
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;

    }

}
