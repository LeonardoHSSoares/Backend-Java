package src.main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.main.java.marcaDeCarro.Fiat;
import src.main.java.marcaDeCarro.Ford;
import src.main.java.marcaDeCarro.Marca;
import src.main.java.marcaDeCarro.Renault;
import src.main.java.marcaDeCarro.Volkswagen;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Marca<String>> fabricas = new ArrayList<>();

            while (true) {
                System.out.println("Digite a marca do carro (Fiat, Ford, Volkswagen, Renault: )");
                System.out.println("digite 'sair' para encerrar: ");
                String marca = scanner.nextLine();
                if (marca.equalsIgnoreCase("sair")) {
                    break;
                }

                Marca<String> factory = null;
                for (Marca<String> indexMarca : fabricas) {
                    if (indexMarca.getMarca().equalsIgnoreCase(marca)) {
                        factory = indexMarca;
                        break;
                    }
                }

                if (factory == null) {
                    switch (marca.toLowerCase()) {
                        case "fiat":
                            factory = new Marca<>(Fiat.class);
                            break;
                        case "ford":
                            factory = new Marca<>(Ford.class);
                            break;
                        case "volkswagen":
                            factory = new Marca<>(Volkswagen.class);
                            break;
                        case "renault":
                            factory = new Marca<>(Renault.class);
                            break;
                        default:
                            System.out.println("Marca de carro não suportada: " + marca);
                            continue;
                    }
                    fabricas.add(factory);
                }

                System.out.println("Digite o modelo do carro:");
                String modelo = scanner.nextLine();
                factory.adicionarModelo(modelo);
            }

            for (Marca<String> factory : fabricas) {
                System.out.println("Marca: " + factory.getMarca());
                for (String modelo : factory.getModelos()) {
                    System.out.println("Modelo: " + modelo);
                }
                System.out.println();
            }
        }
    }
}
