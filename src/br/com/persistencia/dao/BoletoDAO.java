package br.com.persistencia.dao;

import br.com.model.Boleto;
import java.sql.SQLException;
import java.util.List;

public interface BoletoDAO {

    boolean salvar(Boleto b) throws SQLException;

    boolean remover(int id);

    List<Boleto> listarTodos();

    Boleto listarId(int id);
}