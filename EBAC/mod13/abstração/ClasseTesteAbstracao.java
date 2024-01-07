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


        System.out.println("\n");
        
        //Assalariado
        System.out.println(empregadoAssalariado.getClass().getSimpleName());



        System.out.println("\n");
        
        //Comissionado
        System.out.println(empregadoComissionado.getClass().getSimpleName());



        System.out.println("\n");
    }
}
