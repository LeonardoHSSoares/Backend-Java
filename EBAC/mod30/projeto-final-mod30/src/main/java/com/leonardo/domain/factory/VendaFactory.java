package com.leonardo.domain.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.leonardo.domain.cliente.Cliente;
import com.leonardo.domain.venda.Venda;
import com.leonardo.domain.venda.Venda.Status;

/**
 * @author Leonardo Soares
 *         Fábrica para criar objetos Venda a partir de um ResultSet.
 *         Esta classe é responsável por converter os dados de um ResultSet
 *         em um objeto Venda.
 */
public class VendaFactory {

    public static Venda convert(ResultSet rs) throws SQLException {
        Cliente cliente = ClienteFactory.convert(rs);
        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setId(rs.getLong("ID_VENDA"));
        venda.setCodigo(rs.getString("CODIGO"));
        venda.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
        venda.setDataVenda(rs.getTimestamp("DATA_VENDA").toInstant());
        venda.setStatus(Status.getByName(rs.getString("STATUS_VENDA")));
        return venda;
    }
}
