package EBAC.mod13.abstração;

public class ClasseTesteAbstracao extends Empregado{
    public static void main(String args[]) {

        //instanciando os bjetos empregados
        Horista empregadoHorista = new Horista();
        Assalariado empregadoAssalariado = new Assalariado();
        Comissionado empregadoComissionado = new Comissionado();

        System.out.println("**********************************************");
        //Horista
        System.out.println(empregadoHorista.getClass().getSimpleName());
        
        //armazenando dados do empregado
        empregadoHorista.setNome("Leonardo");
        empregadoHorista.setSobrenome("Soares");
        empregadoHorista.setCpf("1");
        empregadoHorista.setPrecoHora(100d);
        empregadoHorista.setHorasTrabalhadas(45d);
        
        //imprimindo dados do empregado
        System.out.println("Nome: "+empregadoHorista.getNome());
        System.out.println("Sobrenome: "+empregadoHorista.getSobrenome());
        System.out.println("CPF: "+empregadoHorista.getCpf());
        System.out.println("Total para receber: "+empregadoHorista.vencimento());

        System.out.println("\n");
        
        //Assalariado
        System.out.println(empregadoAssalariado.getClass().getSimpleName());
        //armazenando dados do empregado
        empregadoAssalariado.setNome("Veronica");
        empregadoAssalariado.setSobrenome("Soares");
        empregadoAssalariado.setCpf("2");
        empregadoAssalariado.setSalario(1000d);
        
        //imprimindo dados do empregado
        System.out.println("Nome: "+empregadoAssalariado.getNome());
        System.out.println("Sobrenome: "+empregadoAssalariado.getSobrenome());
        System.out.println("CPF: "+empregadoAssalariado.getCpf());
        System.out.println("Salario: "+empregadoAssalariado.vencimento());

        System.out.println("\n");
        
        //Comissionado
        System.out.println(empregadoComissionado.getClass().getSimpleName());
        //armazenando dados do empregado
        empregadoComissionado.setNome("Sophia");
        empregadoComissionado.setSobrenome("Silva");
        empregadoComissionado.setCpf("3");
        empregadoComissionado.setTotalVenda(1000d);
        empregadoComissionado.setTaxaComissao(0.2d);

        //imprimeindo dados do empregado
        System.out.println("Nome: "+empregadoComissionado.getNome());
        System.out.println("Sobrenome: "+empregadoComissionado.getSobrenome());
        System.out.println("CPF: "+empregadoComissionado.getCpf());
        System.out.println("Total para receber: " +empregadoComissionado.vencimento());

        System.out.println("\n");
        
        System.out.println("**********************************************");

        empregadoAssalariado.geraRelatorio(empregadoAssalariado);
        empregadoComissionado.geraRelatorio(empregadoComissionado);
        empregadoHorista.geraRelatorio(empregadoHorista);
        
        

    }

    public Double vencimento() {
        return null;
    }
}
