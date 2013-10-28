
package br.com.persistencia.dao;

import br.com.model.Funcionario;
import java.sql.SQLException;
import java.util.List;



public interface FuncionarioDAO {
    
      int salvar(Funcionario f);

    boolean delete(int id);

    List<Funcionario> listAll();

    Funcionario listById(int id);

    List<Funcionario> listByNome(String nome);
    
    public boolean validaLogin(String login, String senha);
            
}