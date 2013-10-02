package br.com.persistencia.dao;

import java.sql.SQLException;
import java.util.List;

public interface OP {

    boolean salvar(OP op) throws SQLException;

    boolean remover(int id);

    List<OP> listarTodos();

    OP listarId(int id);
}