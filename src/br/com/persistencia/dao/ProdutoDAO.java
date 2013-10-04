
package br.com.persistencia.dao;

import br.com.model.Produto;
import java.sql.SQLException;
import java.util.List;

public interface ProdutoDAO {
    
    boolean salvar(Produto p) throws SQLException;

    boolean remover(int id);

    List<Produto> listarTodos();

    Produto listarId(int id);
    
}