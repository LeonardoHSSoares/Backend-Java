package com.leonardo.infrastructure.dao.produto;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.leonardo.domain.Produto;
import com.leonardo.gateway.IProdutoGateway;
import com.leonardo.infrastructure.dao.generic.GenericDAO;

/**
 * @author Leonardo Soares
 *
 *         Classe ProdutoDAO que implementa a interface IProdutoDAO.
 *
 *         Esta classe é responsável por realizar operações de CRUD (Create,
 *         Read, Update, Delete)
 *         para a entidade Produto no banco de dados.
 *
 *         Ela estende a classe GenericDAO, que fornece implementações genéricas
 *         para operações de banco de dados.
 */
public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoGateway {

    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualizarDados(Produto entity, Produto entityCadastrado) {
        entityCadastrado.setCodigo(entity.getCodigo());
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setDescricao(entity.getDescricao());
        entityCadastrado.setPreco(entity.getPreco());
        entityCadastrado.setQuantidadeEstoque(entity.getQuantidadeEstoque());
    }

    @Override
    protected String getQueryInsercao() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO tb_produto ");
        sb.append("(ID, CODIGO, NOME, DESCRICAO, PRECO, QUANTIDADE_ESTOQUE) ");
        sb.append("VALUES (nextval('sq_produto'),?,?,?,?,?)");
        return sb.toString();
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB_PRODUTO WHERE CODIGO = ?";
    }

    @Override
    protected String getQueryAtualizacao() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE TB_PRODUTO ");
        sb.append("SET CODIGO = ?, ");
        sb.append("NOME = ?, ");
        sb.append("DESCRICAO = ?, ");
        sb.append("PRECO = ?, ");
        sb.append("QUANTIDADE_ESTOQUE = ? ");
        sb.append(" WHERE CODIGO = ?");
        return sb.toString();
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Produto entity) throws SQLException {
        stmInsert.setString(1, entity.getCodigo());
        stmInsert.setString(2, entity.getNome());
        stmInsert.setString(3, entity.getDescricao());
        stmInsert.setBigDecimal(4, entity.getPreco());
        stmInsert.setInt(5, entity.getQuantidadeEstoque());
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmDelete, String valor) throws SQLException {
        stmDelete.setString(1, valor);
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Produto entity) throws SQLException {
        stmUpdate.setString(1, entity.getCodigo());
        stmUpdate.setString(2, entity.getNome());
        stmUpdate.setString(3, entity.getDescricao());
        stmUpdate.setBigDecimal(4, entity.getPreco());
        stmUpdate.setInt(5, entity.getQuantidadeEstoque());
        stmUpdate.setString(6, entity.getCodigo());

    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmUpdate, String valor) throws SQLException {
        stmUpdate.setString(1, valor);
    }

}
