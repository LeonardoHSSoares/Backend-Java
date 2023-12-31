package interpolacao;

import java.text.MessageFormat;

public class ExeInterpolacao {

    private String nome;
    private int idade;
    private double altura;

    public ExeInterpolacao(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public static void main(String[] args) {
        ExeInterpolacao pessoa = new ExeInterpolacao("Leonardo", 30, 1.69);

        desenhaLinha();
        System.out.println("Dados da pessoa");
        System.out.println(String.format("Nome: %s", pessoa.nome));
        System.out.println(String.format("Idade: %s anos.", pessoa.idade));
        System.out.println(String.format("Altura: %s", pessoa.altura));
        desenhaLinha();
        desenhaLinha();
        nivel1(pessoa.nome, pessoa.idade);
        desenhaLinha();
        nivel2(pessoa.nome);
        desenhaLinha();
        nivel3(pessoa.nome, pessoa.idade, pessoa.altura);
        desenhaLinha();
        nivel4(pessoa.nome);
        desenhaLinha();
    }

    // Concatenação Simples.
    public static void nivel1(String nome, int idade) {
        System.out.println("Nivel1 = concatenação simples");

        String texto = String.format("Nome: " + nome + " ,Idade: " + idade);
        System.out.println(texto);

    }

    // Concatenação mais refinada, permite a implementação de somente uma variavel.
    public static void nivel2(String nome) {
        System.out.println("Nivel2 = concatenação moderada");

        String texto = String.format("Seja Bem Vindo %s!", nome);
        System.out.println(String.format("%s, Seja bem vindo ", nome));
        System.out.println(texto);

    }

    // Para mensagens mais complexas, especialmente aquelas que exigem formatação de
    // números e datas, MessageFormat.format() pode ser útil:
    public static void nivel3(String nome, int idade, double altura) {
        System.out.println("Nivel3 = concatenação complexa");
        
        System.out.println(MessageFormat.format("{0}, Voce tem {1} anos e sua altura é {2}", nome, idade, altura));

        String mensagem = MessageFormat.format("Bem Vindo {0}, Voce tem {1} anos e sua altura é {2}", nome, idade,
                altura);

        System.out.println(mensagem);
    }

    // Para operações de string em um loop ou situações que exigem muitas
    // modificações de string, usar StringBuilder (ou StringBuffer em contextos
    // multithread) é mais eficiente:
    private static void nivel4(String nome) {
        StringBuilder escreva = new StringBuilder();

        System.out.println("Nivel1 = concatenação simples");
        escreva.append("Olaá ");
        escreva.append(nome);
        escreva.append(", Seja bem vindo!");
        String mensagem = escreva.toString();

        System.err.println(mensagem);
    }

    // Se estiver usando Java 15 ou superior, você pode aproveitar os Text Blocks
    // para criar strings multilinhas, o que pode tornar a concatenação de strings
    // mais legível, especialmente para strings grandes e complexas. No entanto,
    // ainda não é uma interpolação de string no sentido tradicional.

    /*
     * public static void nivel5(String nome) {
     * 
     * String mensagem = """
     * Olá, %s! Bem-vindo ao programa.
     * """.formatted(nome);
     * System.out.println(mensagem);
     * 
     * }
     */
    public static void desenhaLinha() {
        for (int i = 0; i < 65; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }
}
