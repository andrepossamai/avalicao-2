package br.com.persistencia.daojdbc;

import br.com.model.Funcionario;
import br.com.persistencia.dao.FuncionarioDAO;
import br.com.persistencia.dao.FuncionarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//implements: ligar os comandos (salvar, remover, editar...) ao clienteDAO
//onde o clienteDAO liga ao banco de dados. fazendo assim o armazenamento.
public class FuncionarioDAOJDBC implements FuncionarioDAO {

    private static final String DELETE = "delete from funcionario where id = ?;";
    private static final String LIST = "select * from funcionario;";
    private static final String LISTBYID = "select * from funcionario where id = ?;";
    private static final String INSERT = "insert into funcionario (nome, telefoneContato1, "
            + "telefoneContato2, email, sexo, dataNascimento, cpf, rg, salario, dataAdmissao, "
            + "ctps, senha, login) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE = "update funcionario set nome = ?, telefoneContato1 = ?, "
            + "telefoneContato2 = ?, email = ?, sexo = ?, dataNascimento = ?, cpf = ?, rg = ?, "
            + "salario = ?, dataAdmissao = ?, ctps = ?, senha = ?, login = ? where id = ?;";
    private static final String LISTBYNOME = "select * from funcionario where nome like ?;";
    private final String VERIFICALOGIN = "SELECT LOGIN, SENHA FROM FUNCIONARIO WHERE SENHA = ? AND LOGIN = ? ";

    @Override
    public int salvar(Funcionario f) {
        if (f.getId() == 0) {
            return inserir(f);
        } else {
            return update(f);
        }

    }

    private int inserir(Funcionario f) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;

        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            pstm.setString(1, f.getNome());
            pstm.setString(2, f.getTelefoneContato1());
            pstm.setString(3, f.getTelefoneContato2());
            pstm.setString(4, f.getEmail());
            pstm.setString(5, f.getSexo());
            pstm.setDate(6, new java.sql.Date(f.getDataNascimento().getTime()));
            pstm.setString(7, f.getCpf());
            pstm.setString(8, f.getRg());
            pstm.setDouble(9, (f.getSalario()));
            pstm.setDate(10, new java.sql.Date(f.getDataAdimissao().getTime()));
            pstm.setString(11, f.getCtps());
            pstm.setString(12, f.getSenha());
            pstm.setString(13, f.getLogin());

            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = rs.getInt(1);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir: " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
            }
        }
        return retorno;
    }

    public boolean delete(int id) {
        boolean status = false;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(DELETE);
            pstm.setInt(1, id);
            pstm.execute();
            status = true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir um usuário: " + ex.getMessage());

        } finally {

            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão. " + e.getMessage());
            }
        }
        return status;
    }

    @Override
    public List<Funcionario> listAll() {
        //Cria uma nova conexão
        Connection con = null;
        //Cria o pstm onde vai ser executado o comando
        PreparedStatement pstm = null;
        //Cria o ResultSet onde irá capturar os resultados da consulta
        ResultSet rs = null;
        //Nova lista de usuários
        List<Funcionario> funcionario = new ArrayList<>();
        try {
            //Configura o 'con' com o ConnectionFactory
            con = ConnectionFactory.getConnection();
            //Da o comando ao pstm
            pstm = con.prepareStatement(LIST);
            //Executa a consulta atribuindo os resultados ao ResultSet
            rs = pstm.executeQuery();

            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setTelefoneContato1(rs.getString("telefoneContato1"));
                f.setTelefoneContato2(rs.getString("telefoneContato2"));
                f.setEmail(rs.getString("email"));
                f.setSexo(rs.getString("sexo"));
                f.setDataNascimento(rs.getDate("dataNascimento"));
                f.setCpf(rs.getString("cpf"));
                f.setRg(rs.getString("rg"));
                f.setSalario(rs.getDouble("salario"));
                f.setDataAdimissao(rs.getDate("dataAdmissao"));
                f.setCtps(rs.getString("Ctps"));
                f.setSenha(rs.getString("senha"));
                f.setLogin(rs.getString("login"));
                funcionario.add(f);


            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as pessoas: " + ex.getMessage());
        } finally {
            try {
                //Fecha a conexão
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + ex.getMessage());
            }
        }
        return funcionario;
    }

    @Override
    public Funcionario listById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Funcionario f = new Funcionario();

        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            // inserir comando para pegar todos os dados salvos. [rs.next] passa para proxima linha. 
            while (rs.next()) {
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setTelefoneContato1(rs.getString("telefoneContato1"));
                f.setTelefoneContato2(rs.getString("telefoneContato2"));
                f.setEmail(rs.getString("email"));
                f.setSexo(rs.getString("sexo"));
                f.setDataNascimento(rs.getDate("dataNascimento"));
                f.setCpf(rs.getString("cpf"));
                f.setRg(rs.getString("rg"));
                f.setSalario(rs.getDouble("salario"));
                f.setDataAdimissao(rs.getDate("dataAdmissao"));
                f.setCtps(rs.getString("Ctps"));
                f.setSenha(rs.getString("senha"));
                f.setLogin(rs.getString("login"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o usuario " + e.getMessage());

        } finally {

            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão" + e.getMessage());
            }

        }

        return f;
    }

    private int update(Funcionario f) {
        // cria conexão com banco
        Connection con = null;
        // liga o comando com o banco 
        PreparedStatement pstm = null;
        int retorno = -1;

        try {
            // abre conexão
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, f.getNome());
            pstm.setString(2, f.getTelefoneContato1());
            pstm.setString(3, f.getTelefoneContato2());
            pstm.setString(4, f.getEmail());
            pstm.setString(5, f.getSexo());
            pstm.setDate(6, new java.sql.Date(f.getDataNascimento().getTime()));
            pstm.setString(7, f.getCpf());
            pstm.setString(8, f.getRg());
            pstm.setString(9, String.valueOf(f.getSalario()));
            pstm.setDate(10, new java.sql.Date(f.getDataAdimissao().getTime()));
            pstm.setString(11, f.getCtps());
            pstm.setString(12, f.getSenha());
            pstm.setString(13, f.getLogin());
            pstm.setInt(14, f.getId());
            pstm.execute();
            retorno = f.getId();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar os dados " + e.getMessage());

        } finally {

            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return retorno;
    }

    @Override
    public List<Funcionario> listByNome(String nome) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Funcionario> funcionario = new ArrayList<>();

        try {
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar usuário" + e.getMessage());
        } finally {
            try {
                con = ConnectionFactory.getConnection();
                pstm = con.prepareStatement(LISTBYNOME);
                pstm.setString(1, "%" + nome + "%");
                rs = pstm.executeQuery();
                while (rs.next()) {
                    Funcionario f = new Funcionario();
                    f.setId(rs.getInt("id"));
                    f.setNome(rs.getString("nome"));
                    f.setTelefoneContato1(rs.getString("telefoneContato1"));
                    f.setTelefoneContato2(rs.getString("telefoneContato2"));
                    f.setEmail(rs.getString("email"));
                    f.setSexo(rs.getString("sexo"));
                    f.setDataNascimento(rs.getDate("dataNascimento"));
                    f.setCpf(rs.getString("cpf"));
                    f.setRg(rs.getString("rg"));
                    f.setSalario(rs.getDouble("salario"));
                    f.setDataAdimissao(rs.getDate("dataAdmissao"));
                    f.setCtps(rs.getString("Ctps"));
                    f.setSenha(rs.getString("senha"));
                    f.setLogin(rs.getString("login"));
                    funcionario.add(f);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());

            }
        }
        return funcionario;
    }

   
    public boolean validaLogin(String login, String senha) {
        boolean autenticado = false;
        //conectar com banco
        Connection conn = null;
        //pra enviar alguma coisa pro banco
        PreparedStatement pstm = null;
        //receber alguma coisa do banco
        ResultSet rs;
        Funcionario funcionario = new Funcionario();
        try {
            //conectar com banco
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(VERIFICALOGIN);
            pstm.setString(1, senha);
            pstm.setString(2, login);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }

            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao validar login e senha: " + e.getMessage());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao validar login e senha: " + e.getMessage());
        }
        return autenticado;
    }   
}