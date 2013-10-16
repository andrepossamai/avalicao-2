package br.com.persistencia.daojdbc;

import br.com.model.Boleto;
import br.com.persistencia.dao.BoletoDAO;
import br.com.persistencia.dao.BoletoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BoletoDAOJDBC implements BoletoDAO {

    private static final String DELETE = "";
    private static final String LIST = "";
    private static final String LISTBYID = "";
    private static final String INSERT = "";
    private static final String UPDATE = "";

    @Override
    public boolean salvar(Boleto b) throws SQLException {
        if (b.getId() == 0) {
            return inserir(b);
        } else {
            return editar(b);
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
            JOptionPane.showMessageDialog(null, "Erro ao excluir um cliente físico" + e);
            return false;
        }
    }

    @Override
    public List<Boleto> listarTodos() {
        Connection conn;
        List<Boleto> boleto = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
           
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Boleto b = new Boleto();
                b.setId(rs.getInt("codigo"));
                b.setCliente(rs.getString("nome"));
                b.setDataServico(rs.getDate("dataCadastro"));
                b.setLote(rs.getString("telefoneContato1"));
                b.setServico(rs.getString("telefoneContato2"));
                b.setValor(rs.getDouble("email"));
                boleto.add(b);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o cliente físico: " + ex);
        }
        return boleto;
    }

    @Override
    public Boleto listarId(int id) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LISTBYID);
           
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Boleto b = new Boleto();
                b.setId(rs.getInt("codigo"));
                b.setCliente(rs.getString("nome"));
                b.setDataServico(rs.getDate("dataCadastro"));
                b.setLote(rs.getString("telefoneContato1"));
                b.setServico(rs.getString("telefoneContato2"));
                b.setValor(rs.getDouble("email"));
                return b;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar cliente físico" + e);
        }
        return null;
    }

    private boolean inserir(Boleto b) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);
            
            pstm.setString(1, b.getCliente());
            pstm.setDate(2, new java.sql.Date(b.getDataServico().getTime()));
            pstm.setString(3, b.getLote());
            pstm.setString(4, b.getServico());
            pstm.setDouble(5, b.getValor());
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

    private boolean editar(Boleto b) {

        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);

            pstm.setString(1, b.getCliente());
            pstm.setDate(2, new java.sql.Date(b.getDataServico().getTime()));
            pstm.setString(3, b.getLote());
            pstm.setString(4, b.getServico());
            pstm.setDouble(5, b.getValor());
            pstm.execute();
            pstm.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar cliente físico" + e);
        }
        return false;
    }
}