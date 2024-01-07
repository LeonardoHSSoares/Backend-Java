package EBAC.mod13.abstração;

public class ClasseTesteAbstracao {
    public static void main(String args[]) {

        Empregado empregadoHorista = new Horista();
        Empregado empregadoAssalariado = new Assalariado();
        Empregado empregadoComissionado = new Comissionado();

        //Horista
        System.out.println(empregadoHorista.getClass().getSimpleName());
        empregadoHorista.setNome("Leonardo");
        empregadoHorista.setSobrenome("Soares");
        empregadoHorista.setCpf("1");
        System.out.println(empregadoHorista.getNome());
        System.out.println(empregadoHorista.getSobrenome());
        System.out.println(empregadoHorista.getCpf());

        System.out.println("\n");
        
        //Assalariado
        System.out.println(empregadoAssalariado.getClass().getSimpleName());
        empregadoAssalariado.setNome("Veronica");
        empregadoAssalariado.setSobrenome("Soares");
        empregadoAssalariado.setCpf("2");
        System.out.println(empregadoAssalariado.getNome());
        System.out.println(empregadoAssalariado.getSobrenome());
        System.out.println(empregadoAssalariado.getCpf());

        System.out.println("\n");
        
        //Comissionado
        System.out.println(empregadoComissionado.getClass().getSimpleName());
        empregadoComissionado.setNome("Sophia");
        empregadoComissionado.setSobrenome("Silva");
        empregadoComissionado.setCpf("3");
        System.out.println(empregadoComissionado.getNome());
        System.out.println(empregadoComissionado.getSobrenome());
        System.out.println(empregadoComissionado.getCpf());

        System.out.println("\n");
    }
}
