
package br.com.persistencia.dao;

import br.com.model.Funcionario;
import java.sql.SQLException;
import java.util.List;



public interface FuncionarioDAO {
     boolean salvar(Funcionario fu)  throws SQLException;

    boolean remover(int id);

    List<Funcionario> listarTodos();

    Funcionario listarId(int id);
}