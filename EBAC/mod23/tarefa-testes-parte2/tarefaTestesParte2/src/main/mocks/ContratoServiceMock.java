package main.mocks;

import main.dao.IClienteDAO;

public class ContratoServiceMock implements IClienteDAO{

    @Override
    public String salvar() {
        return "Sucesso";
       
    }

}
