
package br.com.persistencia.dao;

import br.com.model.ClienteJuridico;
import java.sql.SQLException;
import java.util.List;



public interface ClienteJuridicoDAO {

    boolean salvar(ClienteJuridico cj) throws SQLException;

    boolean remover(int id);

    List<ClienteJuridico> listarTodos();

    ClienteJuridico listarId(int id);
}