package com.leonardo;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        // Verifica se o número de argumentos é menor que 5
        if (args.length < 5) {
            System.out.println("Por favor, forneça todos os parâmetros necessários.");
            return;
        }
        // Verifica se o telefone é um número inteiro
        try {
            Integer.valueOf(args[3]);
        } catch (NumberFormatException e) {
            System.out.println("O telefone deve ser um número inteiro.");
            return;
        }
        // Verifica se o CPF é um número inteiro
        try {
            Integer.valueOf(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("O CPF deve ser um número inteiro.");
            return;
        }
        // Verifica se o nome é uma string
        if (args[0].isEmpty()) {
            System.out.println("O nome não pode ser vazio.");
            return;
        }
        // Verifica se o email é uma string
        if (args[2].isEmpty()) {
            System.out.println("O email não pode ser vazio.");
            return;
        }
        // Verifica se o endereço é uma string
        if (args[4].isEmpty()) {
            System.out.println("O endereço não pode ser vazio.");
            return;
        }

        String nome = args[0];
        String cpf = args[1];
        String email = args[2];
        Integer telefone = Integer.parseInt(args[3]);
        String endereco = args[4];
        System.out.println("Hello world!");
    }
}