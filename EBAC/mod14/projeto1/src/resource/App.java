package resource;

import javax.swing.JOptionPane;

import resource.dao.ClienteSetDAO;
import resource.dao.IClienteDAO;
import resource.domain.Cliente;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {

        iClienteDAO = new ClienteSetDAO();

        String opcao = JOptionPane.showInputDialog(null,
                "Digite: \n1) Cadastro\n2) Consultar\n3) Excluir\n4) Alterar\n5) Sair",
                "Green dinner", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção inválida!\nDigite: \n1) Cadastro\n2) Consultar\n3) Excluir\n4) Alterar\n5) Sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)) {

            if (isOpcaoSair(opcao)) {
                sair();
            } else if (isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vígula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade , Estado",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isConsulta(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente",
                        "Consulta cliente", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            } else if (isExclusao(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente",
                        "Consulta cliente", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            } else {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vígula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Atualização", JOptionPane.INFORMATION_MESSAGE);
                atualizar(dados);
            }

            opcao = JOptionPane.showInputDialog(null,
                    "Digite: \n1) Cadastro\n2) Consultar\n3) Excluir\n4) Alterar\n5) Sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    private static void atualizar(String dados) {
        String[] dadosSeparados = dados.split(",");
        if (dadosSeparados.length != 7) {
            JOptionPane.showMessageDialog(null, "Dados incompletos", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            Long cpf = Long.parseLong(dadosSeparados[1].trim());
            Long tel = Long.parseLong(dadosSeparados[2].trim());
            Integer numCasa = Integer.parseInt(dadosSeparados[4].trim());
            Cliente cliente = new Cliente(dadosSeparados[0].trim(), cpf, tel, dadosSeparados[3].trim(), numCasa, dadosSeparados[5].trim(), dadosSeparados[6].trim());
            iClienteDAO.alterar(cliente);
        }
    }

    private static void excluir(String dados) {
        try {
            long cpf = Long.parseLong(dados);
            iClienteDAO.excluir(cpf);
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CPF inválido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void consultar(String dados) {
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado com sucesso: " + cliente.toString(), "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        if (dadosSeparados.length != 7) {
            JOptionPane.showMessageDialog(null, "Dados incompletos", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Long cpf = Long.parseLong(dadosSeparados[1].trim());
            Long tel = Long.parseLong(dadosSeparados[2].trim());
            Integer numCasa = Integer.parseInt(dadosSeparados[4].trim());
            Cliente cliente = new Cliente(dadosSeparados[0].trim(), cpf, tel, dadosSeparados[3].trim(), numCasa, dadosSeparados[5].trim(), dadosSeparados[6].trim());
            Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
            if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Formato de numero invalido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean isExclusao(String opcao) {
        return "3".equals(opcao);
    }

    private static boolean isConsulta(String opcao) {
        return "2".equals(opcao);
    }

    private static boolean isCadastro(String opcao) {
        return "1".equals(opcao);
    }

    private static void sair() {
        String clientesCadastrados = "";
        for (Cliente cliente : iClienteDAO.buscarTodos()) {
            clientesCadastrados += cliente.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, "Clientes cadastrados: " + clientesCadastrados, "Até logo",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoSair(String opcao) {
        return "5".equals(opcao);
    }

    private static boolean isOpcaoValida(String opcao) {
        return opcao.matches("[1-5]");
    }
}
