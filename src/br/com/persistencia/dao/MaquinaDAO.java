package br.com.persistencia.dao;

import br.com.model.Maquina;
import java.sql.SQLException;
import java.util.List;

//interface = cria os métodos para as classes DAOJDBC
public interface MaquinaDAO {

    boolean salvar(Maquina mq) throws SQLException;

    boolean remover(int id);

    List<Maquina> listarTodos();

    Maquina listarId(int id);
}