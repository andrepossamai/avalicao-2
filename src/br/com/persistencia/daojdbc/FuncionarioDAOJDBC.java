package br.com.persistencia.daojdbc;

import br.com.model.Funcionario;
import br.com.persistencia.dao.FuncionarioDAO;
import br.com.persistencia.dao.FuncionarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//implements: ligar os comandos (salvar, remover, editar...) ao clienteDAO
//onde o clienteDAO liga ao banco de dados. fazendo assim o armazenamento.
public class FuncionarioDAOJDBC implements FuncionarioDAO {

    private static final String DELETE = "delete from funcionario where codigo = ?;";
    private static final String LIST = "select * from funcionario;";
    private static final String LISTBYID = "select * from funcionario where codigo + ?;";
    private static final String INSERT = "insert into funcionario (salario, dataAdimissao, ctps, cpf, rg, "
            + " nome, telefoneContato1, telefoneContato2, email, endereco) values (?,?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE = "update funcionario set salario = ?, dataAdimissao = ?, ctps = ?, cpf = ?, rg = ?, "
            + " nome = ?, telefoneContato1 = ?, telefoneContato2 = ?, email = ?, endereco = ? where codigo = ?;";

    @Override
    public boolean salvar(Funcionario f) throws SQLException {
        if (f.getId() == 0) {
            return inserir(f);
        } else {
            return editar(f);
        }

    }

    @Override
    public boolean remover(int id) {
        //liga a conexão com o banco de dados. Está na classe ConnectionFactory
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);
            pstm.setInt(1, id);
            pstm.execute();
            return true;


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir um funcionário" + e);
            return false;
        }
    }

    @Override
    public List<Funcionario> listarTodos() {
        Connection conn;
        List<Funcionario> funcionario = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("codigo"));
                f.setNome(rs.getString("nome"));
                f.setTelefoneContato1(rs.getString("telefoneContato1"));
                f.setTelefoneContato2(rs.getString("telefoneContato2"));
                f.setEmail(rs.getString("email"));
                f.setEndereco(rs.getInt("endereço"));
                f.setCpf(rs.getString("cpf"));
                f.setRg(rs.getString("rg"));
                f.setDataAdimissao(rs.getDate("dataAdmissao"));
                f.setCtps(rs.getString("Ctps"));
                f.setSalario(rs.getDouble("salário"));
                funcionario.add(f);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o funcionário: " + ex);
        }
        return funcionario;
    }

    @Override
    public Funcionario listarId(int id) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("codigo"));
                f.setNome(rs.getString("nome"));
                f.setTelefoneContato1(rs.getString("telefoneContato1"));
                f.setTelefoneContato2(rs.getString("telefoneContato2"));
                f.setEmail(rs.getString("email"));
                f.setEndereco(rs.getInt("endereço"));
                f.setCpf(rs.getString("cpf"));
                f.setRg(rs.getString("rg"));
                f.setDataAdimissao(rs.getDate("dataAdmissao"));
                f.setCtps(rs.getString("Ctps"));
                f.setSalario(rs.getDouble("salário"));
                return f;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar funcionário" + e);
        }
        return null;
    }

    private boolean inserir(Funcionario f) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);

            pstm.setDouble(1, f.getSalario());
            pstm.setDate(2, new java.sql.Date(f.getDataAdimissao().getTime()));
            pstm.setString(3, f.getCtps());
            pstm.setString(4, f.getCpf());
            pstm.setString(5, f.getRg());
            pstm.setString(6, f.getNome());
            pstm.setString(7, f.getTelefoneContato1());
            pstm.setString(8, f.getTelefoneContato2());
            pstm.setString(9, f.getEmail());
            pstm.setInt(10, f.getEndereco());
            pstm.execute();
            pstm.close();
            conn.close();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir" + ex);
            conn.close();
            return false;
        }
    }

    private boolean editar(Funcionario f) {

        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);

            pstm.setDouble(1, f.getSalario());
            pstm.setDate(2, new java.sql.Date(f.getDataAdimissao().getTime()));
            pstm.setString(3, f.getCtps());
            pstm.setString(4, f.getCpf());
            pstm.setString(5, f.getRg());
            pstm.setString(6, f.getNome());
            pstm.setString(7, f.getTelefoneContato1());
            pstm.setString(8, f.getTelefoneContato2());
            pstm.setString(9, f.getEmail());
            pstm.setInt(10, f.getEndereco());
            pstm.execute();
            pstm.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar funcionário" + e);
        }
        return false;
    }
}