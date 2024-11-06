package main.dao;

public class ClienteDAO implements IClienteDAO {

    @Override
    public String salvar() {
        throw new UnsupportedOperationException("Sem config à base de dados");
    }

    @Override
    public String atualizar() {
        throw new UnsupportedOperationException("Sem config à base de dados");
    }

    @Override
    public String excluir() {
        throw new UnsupportedOperationException("Sem config à base de dados");
    }

    @Override
    public String consultar() {
        throw new UnsupportedOperationException("Sem config à base de dados");
    }
}