package main.mocks;

import main.dao.IClienteDAO;

public class ClienteDAOMock implements IClienteDAO {

    @Override
    public String salvar() {
        return "Mock - Sucesso ao salvar";
    }

    @Override
    public String atualizar() {
        return "Mock - Sucesso ao atualizar";
    }

    @Override
    public String excluir() {
        return "Mock - Sucesso ao excluir";
    }

    @Override
    public String consultar() {
        return "Mock - Sucesso ao consultar";
    }
}