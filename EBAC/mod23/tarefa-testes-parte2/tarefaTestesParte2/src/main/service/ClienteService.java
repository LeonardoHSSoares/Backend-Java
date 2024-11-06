package main.service;

import main.dao.IClienteDAO;

public class ClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public String salvar() {
        clienteDAO.salvar();
        return "Sucesso ao salvar";
    }

    public String atualizar() {
        clienteDAO.atualizar();
        return "Sucesso ao atualizar";
    }

    public String excluir() {
        clienteDAO.excluir();
        return "Sucesso ao excluir";
    }

    public String consultar() {
        clienteDAO.consultar();
        return "Sucesso ao consultar";
    }
}