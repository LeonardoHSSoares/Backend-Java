package com.leonardo.dao.produto;

import com.leonardo.dao.generic.IGenericDAO;
import com.leonardo.domain.produto.Produto;

/**
 * @author Leonardo Soares
 *
 *         Interface IProdutoDAO que estende a interface IGenericDAO.
 *
 *         Esta interface é responsável por definir os métodos específicos para
 *         operações de CRUD (Create, Read, Update, Delete)
 *         para a entidade Produto no banco de dados.
 */
public interface IProdutoDAO extends IGenericDAO<Produto, String> {
    
    

}
