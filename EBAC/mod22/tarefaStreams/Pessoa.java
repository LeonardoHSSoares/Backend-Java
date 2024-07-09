
public class Pessoa implements IUsuario {

    String nome;
    String genero;


    public Pessoa() {
    }

    public Pessoa(String nome, String genero) {
        this.nome = nome;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return Pessoa.class.getSimpleName()+" [Nome= " + nome + ", Genero= " + genero + "]";
    }

    @Override
    public Pessoa coletaDados(String entrada) {

        if (entrada.split(",").length != 2) {   
            System.out.println("Nome Invalido!");
        } else {

            String[] entradaDividida = entrada.split(",");
            String nome = entradaDividida[0].toUpperCase();
            String genero = entradaDividida[1].equalsIgnoreCase("f") ? "Feminino" : "Masculino";
            return new Pessoa(nome, genero);
        }
        return null;
    }

   
 
}
