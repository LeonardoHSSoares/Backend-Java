package com.leonardo.domain;

import com.leonardo.annotation.ColunaTabela;
import com.leonardo.annotation.Tabela;
import com.leonardo.annotation.TipoChave;
import com.leonardo.infrastructure.dao.Persistence;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Leonardo Soares
 *
 *         Classe Cliente que representa um cliente no sistema.
 *         Esta classe contém informações como nome, CPF, telefone, endereço,
 *         número, cidade, estado e email.
 *         Ela implementa a interface Persistence para garantir que tenha um
 *         identificador único (ID).
 */
@Getter
@Setter
@Tabela("TB_CLIENTE")
public class Cliente implements Persistence {
	
	@ColunaTabela(dbName = "id", setJavaName = "setId")
	private Long id;
	
	@ColunaTabela(dbName = "nome", setJavaName = "setNome")
	private String nome;
	
	@TipoChave("getCpf")
	@ColunaTabela(dbName = "cpf", setJavaName = "setCpf")
    private Long cpf;
    
	@ColunaTabela(dbName = "tel", setJavaName = "setTel")
    private Long tel;
    
	@ColunaTabela(dbName = "endereco", setJavaName = "setEnd")
    private String end;
    
	@ColunaTabela(dbName = "numero", setJavaName = "setNumero")
    private Integer numero;
    
	@ColunaTabela(dbName = "cidade", setJavaName = "setCidade")
    private String cidade;
    
	@ColunaTabela(dbName = "estado", setJavaName = "setEstado")
    private String estado;

	@ColunaTabela(dbName = "email", setJavaName = "setEmail")
	private String email;
    

}
