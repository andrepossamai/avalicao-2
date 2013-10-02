
package br.com.persistencia.dao;

import br.com.model.MateriaPrima;
import java.sql.SQLException;
import java.util.List;

public interface MateriaPrimaDAO {
    
    boolean salvar(MateriaPrima mp) throws SQLException;

    boolean remover(int id);

    List<MateriaPrima> listarTodos();

    MateriaPrima listarId(int id);
    
}