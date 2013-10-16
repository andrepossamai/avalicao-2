package br.com.persistencia.daojdbc;

import br.com.model.Maquina;
import br.com.persistencia.dao.MaquinaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//implements: ligar os comandos (salvar, remover, editar...) ao clienteDAO
//onde o clienteDAO liga ao banco de dados. fazendo assim o armazenamento.
public class MaquinaDAOJDBC implements MaquinaDAO {

    private static final String DELETE = "";
    private static final String LIST = "";
    private static final String LISTBYID = "";
    private static final String INSERT = "";
    private static final String UPDATE = "";

    @Override
    public boolean salvar(Maquina m) throws SQLException {
        if (m.getId() == 0) {
            return inserir(m);
        } else {
            return editar(m);
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
            JOptionPane.showMessageDialog(null, "Erro ao excluir um máquina" + e);
            return false;
        }
    }

    @Override
    public List<Maquina> listarTodos() {
        Connection conn;
        List<Maquina> maquina = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Maquina m = new Maquina();
                m.setId(rs.getInt("codigo"));
                m.setNome(rs.getString("nome"));
                m.setFornecedor(rs.getString("fornecedor"));
                m.setDataCompra(rs.getString("dataCompra"));
                m.setFuncao(rs.getString("funcao"));
                m.setValor(rs.getDouble("valor"));
                m.setQuantidade(rs.getInt("quantidade"));
                maquina.add(m);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar a máquina: " + ex);
        }
        return maquina;
    }

    @Override
    public Maquina listarId(int id) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Maquina m = new Maquina();
                m.setId(rs.getInt("codigo"));
                m.setNome(rs.getString("nome"));
                m.setFornecedor(rs.getString("fornecedor"));
                m.setDataCompra(rs.getString("dataCompra"));
                m.setFuncao(rs.getString("funcao"));
                m.setValor(rs.getDouble("valor"));
                m.setQuantidade(rs.getInt("quantidade"));
                return m;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar máquina" + e);
        }
        return null;
    }

    private boolean inserir(Maquina m) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);
            
            pstm.setString(1, m.getNome());
            pstm.setString(2, m.getFornecedor());
            pstm.setDate(3, new java.sql.Date(m.getDataCompra().getTime()));
            pstm.setString(4, m.getFuncao());
            pstm.setDouble(5, m.getValor());
            pstm.setInt(6, m.getQuantidade());
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

    private boolean editar(Maquina m) {

        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);

            pstm.setString(1, m.getNome());
            pstm.setString(2, m.getFornecedor());
            pstm.setDate(3, new java.sql.Date(m.getDataCompra().getTime()));
            pstm.setString(4, m.getFuncao());
            pstm.setDouble(5, m.getValor());
            pstm.setInt(6, m.getQuantidade());
            pstm.execute();
            pstm.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar máquina" + e);
        }
        return false;
    }
}