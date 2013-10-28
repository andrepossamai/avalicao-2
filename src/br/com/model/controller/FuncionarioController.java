package br.com.model.controller;

import br.com.model.Funcionario;
import br.com.persistencia.dao.FuncionarioDAO;
import br.com.persistencia.daojdbc.FuncionarioDAOJDBC;
import java.util.List;

public class FuncionarioController {

    public int salvar(Funcionario f) {
        FuncionarioDAO dao = new FuncionarioDAOJDBC();
        return dao.salvar(f);

    }

    public List<Funcionario> listarTodos() {
        FuncionarioDAO dao = new FuncionarioDAOJDBC();
        return dao.listAll();

    }

    public List<Funcionario> listByNome(String nome) {
        FuncionarioDAO dao = new FuncionarioDAOJDBC();
        return dao.listByNome(nome);

    }

    public Funcionario listById(int id) {
        FuncionarioDAO dao = new FuncionarioDAOJDBC();
        return dao.listById(id);

    }

    public boolean delete(int id) {
        FuncionarioDAO dao = new FuncionarioDAOJDBC();
        // chama o id do banco
        return dao.delete(id);
    }

    public boolean validaLogin(String login, String senha) {
        FuncionarioDAO dao = new FuncionarioDAOJDBC();
        return dao.validaLogin(login, senha);
    }
}