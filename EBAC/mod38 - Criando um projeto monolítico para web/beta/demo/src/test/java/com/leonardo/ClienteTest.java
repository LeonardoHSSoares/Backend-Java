package com.leonardo;

import org.junit.Test;

import com.leonardo.domain.Cliente;

public class ClienteTest {
   

    @Test
    public void cadastrarCliente() {
        
        Cliente cliente = new Cliente();
        cliente.setNome("Leonardo");
        cliente.setCpf(12345678901L);
        cliente.setTel(11999999999L);
        cliente.setEmail("asdsd@gmail.com");
        cliente.setEnd("Rua A");
        cliente.setNumero(123);
        cliente.setCidade("São Paulo");
        cliente.setEstado("SP");
        
        
    }

}
