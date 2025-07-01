package com.leonardo.domain.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.leonardo.infrastructure.dao.Persistente;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Leonardo Soares
 *
 * Classe ClienteJPA que representa um cliente no sistema.
 * Esta classe é mapeada para a tabela TB_CLIENTE no banco de dados.
 */
@Getter
@Setter
@Entity
@Table(name = "TB_CLIENTE")
public class ClienteJPA implements Persistente{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_seq")
	@SequenceGenerator(name="cliente_seq", sequenceName="sq_cliente", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "NOME", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "CPF", nullable = false, unique = true)
    private Long cpf;
    
	@Column(name = "TEL", nullable = false)
    private Long tel;
    
	@Column(name = "ENDERECO", nullable = false, length = 100)
    private String end;
    
	@Column(name = "NUMERO", nullable = false)
    private Integer numero;
    
	@Column(name = "CIDADE", nullable = false, length = 100)
    private String cidade;
    
	@Column(name = "ESTADO", nullable = false, length = 50)
    private String estado;
    
	@Column(name = "EMAIL", nullable = false, length = 100)
    private String email;
}
