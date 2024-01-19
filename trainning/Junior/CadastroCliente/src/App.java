import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        //String opcao = JOptionPane.showInputDialog(null, "Digite: \n1) Cadastro\n2) Consultar\n3) Excluir\n4) Alterar\n5) Sair", "Aviso");

        String opcao = JOptionPane.showInputDialog(null, "Digite: \n1) Cadastro\n2) Consultar\n3) Excluir\n4) Alterar\n5) Sair", "Escolha uma opcão de 1 - 5 ", 3);

        switch (opcao) {
            case "1":
                
                break;
                
            case "2":
                
                break;
            
            case "3":
                
                break;
            
            case "4":
                
                break;
            case "5":
            
                break;
            
            default:
                System.out.println("Opção Invalida");
                break;
        }

        String dados = JOptionPane.showInputDialog(null, "Digite: \n1) Cadastro\n2) Consultar\n3) Excluir\n4) Alterar\n5) Sair","");

        String[] dadosSeparados = dados.split(dados);
        String dadosNome = dadosSeparados[0];
        String dadosEndereco = dadosSeparados[1];
        String dadosSobrenome = dadosSeparados[2];
        Long[] dadosId = new Long[+1];
        

    }
}
