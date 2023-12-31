package interpolacao;

import java.text.MessageFormat;

public class ExeInterpolacao {

    private String nome = "Leonardo";
    private int idade = 30;
    private double altura = 1.69;

    public static void main(String[] args) {


    }

    // Concatenação Simples.
    public static void nivel1(String nome, int idade) {

        String texto = String.format("Nome: " + nome + " ,Idade: " + idade);

        System.out.println(texto);

    }

    // Concatenação mais refinada, permite a implementação de somente uma variavel.
    public static void nivel2(String nome) {

        String texto = String.format("Seja Bem Vindo %s!", nome);
        System.out.println(String.format("%s, Seja bem vindo ", nome));
        System.out.println(texto);

    }

    //Para mensagens mais complexas, especialmente aquelas que exigem formatação de números e datas, MessageFormat.format() pode ser útil:
    public static void nivel3(String nome, int idade, double altura) {
        System.out.println(MessageFormat.format("{0}, Voce tem {1} anos e sua altura é {2}", nome, idade, altura));

        String mensagem = MessageFormat.format("Bem Vindo {0}, Voce tem {1} anos e sua altura é {2}", nome, idade,
                altura);

        System.out.println(mensagem);
    }

    //Para operações de string em um loop ou situações que exigem muitas modificações de string, usar StringBuilder (ou StringBuffer em contextos multithread) é mais eficiente:
    private static void nivel4(String nome) {
        
        StringBuilder escreva = new StringBuilder();

        escreva.append("Olaá ");
        escreva.append(nome);
        escreva.append(", Seja bem vindo!");
        String mensagem = escreva.toString();
        
        System.err.println(mensagem);
    }

    //Se estiver usando Java 15 ou superior, você pode aproveitar os Text Blocks para criar strings multilinhas, o que pode tornar a concatenação de strings mais legível, especialmente para strings grandes e complexas. No entanto, ainda não é uma interpolação de string no sentido tradicional.
    
    /*public static void nivel5(String nome) {
        
        String mensagem = """
        Olá, %s! Bem-vindo ao programa.
        """.formatted(nome);
        System.out.println(mensagem);

    }*/

}
