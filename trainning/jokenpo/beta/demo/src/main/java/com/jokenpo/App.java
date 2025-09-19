package com.jokenpo;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Leonardo Soares
 * @version 1.0
 *          Jokenpo Game
 *          esta é uma aplicação simples de Jokenpo (Pedra, Papel, Tesoura).
 *          O usuário escolhe uma das opções e o computador escolhe
 *          aleatoriamente.
 *          O resultado é então determinado com base nas regras do jogo.
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        StringBuilder inicio = new StringBuilder();
        escreveLinha();
        inicio.append("\nWelcome to Jokenpo!\n")
                .append("\nChoose your move: \n")
                .append("1) Pedra\n")
                .append("2) Papel\n")
                .append("3) Tesoura\n")
                .append("4) Sair\n");
                
        System.out.println(inicio);

        int escolhaUsuario = scanner.nextInt();
        int escolhaComputador = random.nextInt(3) + 1;

            


    }

    public static void escreveLinha() {
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
    }

    public static String escolha(int escolha) {
        switch (escolha) {
            case 1:
                return "Pedra";
            case 2:
                return "Papel";
            case 3:
                return "Tesoura";
            case 4:
                return "Saiu do jogo!";
            default:
                return "Opção inválida";
        }
    }
}
