package com.leonardo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.leonardo.dao.generic.GenericDAO;
import static com.leonardo.dao.generic.jdbc.ConnectionFactory.getConnection;
import com.leonardo.domain.Venda;
import com.leonardo.domain.Venda.Status;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

public class VendaDAO extends GenericDAO<Venda, String> implements IVendaDAO {

	@Override
	public Class<Venda> getTipoClasse() {
		return Venda.class;
	}

	@Override
	public void atualiarDados(Venda entity, Venda entityCadastrado) {
		entityCadastrado.setCodigo(entity.getCodigo());
		entityCadastrado.setStatus(entity.getStatus());
	}

	@Override
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException {
		venda.setStatus(Status.CONCLUIDA);
		super.alterar(venda);
	}

	@Override
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			String sql = "UPDATE TB_VENDA SET STATUS_VENDA = ? WHERE ID = ?";
			connection = getConnection();
			stm = connection.prepareStatement(sql);
			stm.setString(1, Status.CANCELADA.name());
			stm.setLong(2, venda.getId());
			stm.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("ERRO ATUALIZANDO OBJETO ", e);
		} finally {
			closeConnection(connection, stm, null);
		}
	}

}
