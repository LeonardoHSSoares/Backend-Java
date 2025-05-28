package com.leonardo.simpleapp;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.leonardo.simpleapp.domain.Cliente;
import com.leonardo.simpleapp.repository.IClienteRepository;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "com.leonardo.simpleapp.repository")
@EntityScan(basePackages = "com.leonardo.simpleapp.domain")
@ComponentScan(basePackages = "com.leonardo.simpleapp")
public class SimpleappApplication implements CommandLineRunner {

	//static final Logger log = Logger.getLogger(SimpleappApplication.class.getName());
	private static final Logger log = Logger.getLogger(SimpleappApplication.class.getName());

	@Autowired
	private IClienteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SimpleappApplication.class, args);

	}

    
	@Override
	public void run(String... args) throws Exception {
		log.info("Running SimpleappApplication...");
		Cliente cliente = createCliente();
		repository.save(cliente);
	}

	private Cliente createCliente() {
		return Cliente.builder()
				.nome("Leonardo")
				.cpf("12345678901")
				.telefone("11987654321")
				.endereco("Rua Exemplo, 123")
				.build();
	}

}
