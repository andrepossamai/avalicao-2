package br.com.persistencia.dao;


import br.com.model.Fornecedor;
import br.com.model.Funcionario;
import java.sql.SQLException;
import java.util.List;

public interface FornecedorDAO {

    boolean salvar(Fornecedor fo) throws SQLException;

    boolean remover(int id);

    List<Fornecedor> listarTodos();

    Fornecedor listarId(int id);
}
