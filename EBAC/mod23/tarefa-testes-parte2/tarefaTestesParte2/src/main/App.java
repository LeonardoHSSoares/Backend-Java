package main;

import main.dao.ClienteDAO;
import main.mocks.ClienteDAOMock;
import main.service.ClienteService;
import main.service.ContratoService;

public class App {
    public static void main(String[] args) {
        
        // Usando mock para ClienteService
        ClienteService clienteServiceComMock = new ClienteService(new ClienteDAOMock());
        System.out.println("Resultado ClienteService (Mock): " + clienteServiceComMock.salvar());

        // Usando ClienteDAO real para ContratoService (gera exceção)
        try {
            ContratoService contratoService = new ContratoService(new ClienteDAO());
            System.out.println("Resultado ContratoService: " + contratoService.salvar());
        } catch (UnsupportedOperationException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}

