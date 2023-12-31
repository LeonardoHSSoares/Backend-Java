package construtores;

import java.util.Scanner;

/**
 * Main
 */
public class Pessoa {

  private String primeiroNome;
  private String ultimoNome;
  private int idade;

  //Criado construtor para classe Pessoa
  public Pessoa(String primeiroNome, String ultimoNome, int idade) {
    this.primeiroNome = primeiroNome;
    this.ultimoNome = ultimoNome;
    this.idade = idade;
  }
  public String getPrimeiroNome() {
    return primeiroNome;
  } 
  public String getUltimoNome() {
    return ultimoNome;
  }
  public int getIdade() {
    return idade;
  }
  public void setIdade(int idade) {
    this.idade = idade;
  }
  public static void main(String[] args) {
    Pessoa cliente = new Pessoa("Leonardo","Soares",30);
    Scanner leia = new Scanner(System.in);

    System.out.print("\033[H\033[2J");
    System.out.println(String.format("%s ,Digite sua idade: ", cliente.primeiroNome));
    int idade = leia.nextInt();
    leia.close();
    System.out.print("\033[H\033[2J");
  
    System.out.println(idade);

    

    

  }
}