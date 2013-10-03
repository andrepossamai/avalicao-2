package br.com.persistenciaa;

import br.com.model.Fornecedor;
import br.com.persistencia.dao.FornecedorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//implements: ligar os comandos (salvar, remover, editar...) ao clienteDAO
//onde o clienteDAO liga ao banco de dados. fazendo assim o armazenamento.
public class FornecedorDAOJDBC implements FornecedorDAO {

    private static final String DELETE = "";
    private static final String LIST = "";
    private static final String LISTBYID = "";
    private static final String INSERT = "";
    private static final String UPDATE = "";

    @Override
    public boolean salvar(Fornecedor f) throws SQLException {
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
            JOptionPane.showMessageDialog(null, "Erro ao excluir um fornecedor" + e);
            return false;
        }
    }

    @Override
    public List<Fornecedor> listarTodos() {
        Connection conn;
        List<Fornecedor> fornecedor = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("codigo"));
                f.setNome(rs.getString("nome"));
                f.setDataCadastro(rs.getDate("dataCadastro"));
                f.setTelefoneContato1(rs.getString("telefoneContato1"));
                f.setTelefoneContato2(rs.getString("telefoneContato2"));
                f.setEmail(rs.getString("email"));
                f.setEndereco(rs.getInt("endereço"));
                f.setCnpj(rs.getString("cnpj"));
                fornecedor.add(f);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o fornecedor: " + ex);
        }
        return fornecedor;
    }

    @Override
    public Fornecedor listarId(int id) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("codigo"));
                f.setNome(rs.getString("nome"));
                f.setDataCadastro(rs.getDate("dataCadastro"));
                f.setTelefoneContato1(rs.getString("telefoneContato1"));
                f.setTelefoneContato2(rs.getString("telefoneContato2"));
                f.setEmail(rs.getString("email"));
                f.setEndereco(rs.getInt("endereço"));
                f.setCnpj(rs.getString("cnpj"));
                return f;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar fornecedor" + e);
        }
        return null;
    }

    private boolean inserir(Fornecedor f) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);

            pstm.setString(1, f.getNome());
            pstm.setDate(2, new java.sql.Date(f.getDataCadastro().getTime()));
            pstm.setString(3, f.getTelefoneContato1());
            pstm.setString(4, f.getTelefoneContato2());
            pstm.setString(5, f.getEmail());
            pstm.setString(6, f.getEndereco());
            pstm.setString(7, f.getCnpj());
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

    private boolean editar(Fornecedor f) {

        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);

            pstm.setString(1, f.getNome());
            pstm.setDate(2, new java.sql.Date(f.getDataCadastro().getTime()));
            pstm.setString(3, f.getTelefoneContato1());
            pstm.setString(4, f.getTelefoneContato2());
            pstm.setString(5, f.getEmail());
            pstm.setString(6, f.getEndereco());
            pstm.setString(7, f.getCnpj());
            pstm.execute();
            pstm.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar fornecedor" + e);
        }
        return false;
    }
}