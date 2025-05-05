import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.leonardo.domain.Cliente;

public class LazyLoadingTest {

    private EntityManagerFactory emf;
    private EntityManager em;

    @BeforeEach
    public void init() {
        emf = Persistence.createEntityManagerFactory("ExemploJPA");
        em = emf.createEntityManager();
    }

    @Test
    public void testLazyLoading() {
        em.getTransaction().begin();

        Cliente cliente = new Cliente();
        cliente.setNome("Lazy Test");
        cliente.setCpf("22222222222");
        cliente.setEndereco("Rua Lazy");
        cliente.setTelefone("1122222222");

        em.persist(cliente);
        em.getTransaction().commit();

        em.clear();
        Cliente c = em.find(Cliente.class, cliente.getId());
        assertNotNull(c);
        // Lazy loading apenas será testado quando houver dependência (relacionamento)
    }

    @AfterEach
    public void close() {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }

}
