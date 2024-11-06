package main.service;

import main.dao.IClienteDAO;

public class ContratoService implements IContratoService {

    private IClienteDAO clienteDAO;

    public ContratoService(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public String salvar() {
        clienteDAO.salvar();
        return "Sucesso ao salvar";
    }

    @Override
    public String atualizar() {
        clienteDAO.atualizar();
        return "Sucesso ao atualizar";
    }

    @Override
    public String excluir() {
        clienteDAO.excluir();
        return "Sucesso ao excluir";
    }

    @Override
    public String consultar() {
        clienteDAO.consultar();
        return "Sucesso ao consultar";
    }
}