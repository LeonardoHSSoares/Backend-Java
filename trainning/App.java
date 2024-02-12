import java.util.*;

interface Carro<T> {
    T criarCarro(String modelo);
}

class Marca<T> implements Carro<T> {
    private Class<? extends Carro<T>> tipoCarro;
    private List<String> modelos;

    public Marca(Class<? extends Carro<T>> tipoCarro) {
        this.tipoCarro = tipoCarro;
        this.modelos = new ArrayList<>();
    }

    @Override
    public T criarCarro(String modelo) {
        try {
            return tipoCarro.getDeclaredConstructor(String.class).newInstance(modelo).criarCarro(modelo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getModelos() {
        return modelos;
    }

    public void adicionarModelo(String modelo) {
        modelos.add(modelo);
    }

    public String getMarca() {
        return tipoCarro.getSimpleName();
    }
}

class Fiat implements Carro<String> {
    private String modelo;

    public Fiat(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String criarCarro(String modelo) {
        return "Fiat " + modelo;
    }
}

class Ford implements Carro<String> {
    private String modelo;

    public Ford(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String criarCarro(String modelo) {
        return "Ford " + modelo;
    }
}

class Volkswagen implements Carro<String> {
    private String modelo;

    public Volkswagen(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String criarCarro(String modelo) {
        return "Volkswagen " + modelo;
    }
    
}
class Renault implements Carro<String> {
    private String modelo;

    public Renault(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String criarCarro(String modelo) {
        return "Volkswagen " + modelo;
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Marca<String>> fabricas = new ArrayList<>();

        while (true) {
            System.out.println("Digite a marca do carro (Fiat, Ford ou Volkswagen)");
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