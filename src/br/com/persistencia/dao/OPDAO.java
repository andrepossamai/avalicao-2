package br.com.persistencia.dao;

import java.sql.SQLException;
import java.util.List;

public interface OPDAO {

    boolean salvar(OPDAO op) throws SQLException;

    boolean remover(int id);

    List<OPDAO> listarTodos();

    OPDAO listarId(int id);
}