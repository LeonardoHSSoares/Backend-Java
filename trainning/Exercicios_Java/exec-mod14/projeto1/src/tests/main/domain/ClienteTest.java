package tests.main.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.domain.Cliente;

public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    public void setup() {
        cliente = new Cliente("João Silva", 12345678901L, 11987654321L, "Rua A", 100, "São Paulo", "SP");
    }

    @Test
    public void testGetters() {
        assertEquals("João Silva", cliente.getNome());
        assertEquals(12345678901L, cliente.getCpf());
        assertEquals(11987654321L, cliente.getTel());
        assertEquals("Rua A", cliente.getEndereco());
        assertEquals(100, cliente.getNumCasa());
        assertEquals("São Paulo", cliente.getCidade());
        assertEquals("SP", cliente.getEstado());
    }

    @Test
    public void testSetters() {
        cliente.setNome("Maria Silva");
        cliente.setCpf(98765432101L);
        cliente.setTel(11912345678L);
        cliente.setEndereco("Rua B");
        cliente.setNumCasa(200);
        cliente.setCidade("Rio de Janeiro");
        cliente.setEstado("RJ");

        assertEquals("Maria Silva", cliente.getNome());
        assertEquals(98765432101L, cliente.getCpf());
        assertEquals(11912345678L, cliente.getTel());
        assertEquals("Rua B", cliente.getEndereco());
        assertEquals(200, cliente.getNumCasa());
        assertEquals("Rio de Janeiro", cliente.getCidade());
        assertEquals("RJ", cliente.getEstado());
    }

    @Test
    public void testToString() {
        String expected = "Cliente [Nome = João Silva, CPF = 12345678901, Tel = 11987654321, Endereco = Rua A, NumeroCasa = 100, Cidade = São Paulo, Estado = SP]";
        assertEquals(expected, cliente.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        Cliente clienteIgual = new Cliente("João Silva", 12345678901L, 11987654321L, "Rua A", 100, "São Paulo", "SP");
        Cliente clienteDiferente = new Cliente("Maria Silva", 98765432101L, 11912345678L, "Rua B", 200, "Rio de Janeiro", "RJ");

        assertEquals(cliente, clienteIgual);
        assertNotEquals(cliente, clienteDiferente);
        assertEquals(cliente.hashCode(), clienteIgual.hashCode());
        assertNotEquals(cliente.hashCode(), clienteDiferente.hashCode());
    }

    @Test
    public void testNotEqualsNull() {
        assertNotEquals(cliente, null);
    }

    @Test
    public void testNotEqualsDifferentClass() {
        assertNotEquals(cliente, "String diferente");
    }
}
