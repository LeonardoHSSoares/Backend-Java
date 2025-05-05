import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.leonardo.dao.GenericDAOEntity;
import com.leonardo.dao.IGenericDAO;
import com.leonardo.domain.Acessorio;
import com.leonardo.domain.Carro;
import com.leonardo.domain.Marca;

public class AppDAOTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
    EntityManager em = emf.createEntityManager();

    

    // Criação dos DAOs genéricos
    IGenericDAO<Marca, Long> marcaDAO = new GenericDAOEntity<>(em, Marca.class);
    IGenericDAO<Acessorio, Long> acessorioDAO = new GenericDAOEntity<>(em, Acessorio.class);
    IGenericDAO<Carro, Long> carroDAO = new GenericDAOEntity<>(em, Carro.class);

    @Test
    public void cadastrarTest() {
        // Criando uma nova marca
        Marca marca = new Marca();
        marca.setNome("Fiat");
        marcaDAO.salvar(marca);

        // Criando um novo acessório
        Acessorio acessorio = new Acessorio();
        acessorio.setDescricao("Ar condicionado");
        acessorioDAO.salvar(acessorio);

        // Criando um novo carro
        Carro carro = new Carro();
        carro.setModelo("Palio");
        carro.setAno(2020);
        carro.setMarca(marca);
    
        carroDAO.salvar(carro);
    }

}
