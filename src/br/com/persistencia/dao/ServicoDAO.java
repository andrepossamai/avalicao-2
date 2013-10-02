package br.com.persistencia.dao;

import br.com.model.Funcionario;
import br.com.model.Servico;
import java.sql.SQLException;
import java.util.List;

public interface ServicoDAO {

    boolean salvar(Servico s) throws SQLException;

    boolean remover(int id);

    List<Servico> listarTodos();

    Servico listarId(int id);
}
