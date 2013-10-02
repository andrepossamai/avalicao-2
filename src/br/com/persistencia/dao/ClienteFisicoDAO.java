package br.com.persistencia.dao;

import br.com.model.ClienteFisico;
import java.sql.SQLException;
import java.util.List;



public interface ClienteFisicoDAO {

    boolean salvar(ClienteFisico cf) throws SQLException;

    boolean remover(int id);

    List<ClienteFisico> listarTodos();

    ClienteFisico listarId(int id);
}