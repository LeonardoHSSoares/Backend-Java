package domain;

public class App {

    public static void main(String[] args) {
        
        Funcionario funcionario = new Funcionario("João", 3000);
        funcionario.addAumento(500);
        funcionario.exibeDados();
        System.out.println("Ganho anual: " + funcionario.ganhoAnual());

        System.out.println();

        Assistente assistente = new Assistente("Maria", 2500, 123);
        assistente.addAumento(300);
        assistente.exibeDados();
        System.out.println("Ganho anual: " + assistente.ganhoAnual());

        System.out.println();

        Tecnico tecnico = new Tecnico("Carlos", 2800, 456, 200);
        tecnico.exibeDados();
        System.out.println("Ganho anual: " + tecnico.ganhoAnual());

        System.out.println();

        Administrativo administrativo = new Administrativo("Ana", 2700, 789, "noite", 100);
        administrativo.exibeDados();
        System.out.println("Ganho anual: " + administrativo.ganhoAnual());

    }

    
}
