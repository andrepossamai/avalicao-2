package br.com.persistenciaa;

import br.com.model.ClienteJuridico;
import br.com.model.ClienteJuridico;
import br.com.persistencia.dao.ClienteJuridicoDAO;
import br.com.persistencia.dao.ClienteJuridicoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteJuridicoDAOJDBC implements ClienteJuridicoDAO {

    private static final String DELETE = "";
    private static final String LIST = "";
    private static final String LISTBYID = "";
    private static final String INSERT = "";
    private static final String UPDATE = "";

    @Override
    public boolean salvar(ClienteJuridico cj) throws SQLException {
        if (cj.getId() == 0) {
            return inserir(cj);
        } else {
            return editar(cj);
        }

    }

    @Override
    public boolean remover(int id) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);
            pstm.setInt(1, id);
            pstm.execute();
            return true;


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir um Cliente Jurídico" + e);
            return false;
        }
    }

    @Override
    public List<ClienteJuridico> listarTodos() {
        Connection conn;
        List<ClienteJuridico> clienteJuridico = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ClienteJuridico cj = new ClienteJuridico();
                cj.setId(rs.getInt("codigo"));
                cj.setNome(rs.getString("nome"));
                cj.setDataCadastro(rs.getDate("dataCadastro"));
                cj.setTelefoneContato1(rs.getString("telefoneContato1"));
                cj.setTelefoneContato2(rs.getString("telefoneContato2"));
                cj.setEmail(rs.getString("email"));
                cj.setEndereco(rs.getInt("endereço"));
                cj.setCnpj(rs.getString("cnpj"));
                clienteJuridico.add(cj);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o cliente jurídico: " + ex);
        }
        return clienteJuridico;
    }

    @Override
    public ClienteJuridico listarId(int id) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ClienteJuridico cj = new ClienteJuridico();
                cj.setId(rs.getInt("codigo"));
                cj.setNome(rs.getString("nome"));
                cj.setDataCadastro(rs.getDate("dataCadastro"));
                cj.setTelefoneContato1(rs.getString("telefoneContato1"));
                cj.setTelefoneContato2(rs.getString("telefoneContato2"));
                cj.setEmail(rs.getString("email"));
                cj.setEndereco(rs.getInt("endereço"));
                cj.setCnpj(rs.getString("cnpj"));
                return cj;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar funcionario" + e);
        }
        return null;
    }

    private boolean inserir(ClienteJuridico cj) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);
            pstm.setString(1, cj.getNome());
            pstm.setDate(2, new java.sql.Date(cj.getDataCadastro().getTime()));
            pstm.setString(3, cj.getTelefoneContato1());
            pstm.setString(4, cj.getTelefoneContato2());
            pstm.setString(5, cj.getEmail());
            pstm.setInt(6, cj.getEndereco());
            pstm.setString(7, cj.getCnpj());
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

    private boolean editar(ClienteJuridico cj) {

        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);

            pstm.setString(1, cj.getNome());
            pstm.setDate(2, new java.sql.Date(cj.getDataCadastro().getTime()));
            pstm.setString(3, cj.getTelefoneContato1());
            pstm.setString(4, cj.getTelefoneContato2());
            pstm.setString(5, cj.getEmail());
            pstm.setInt(6, cj.getEndereco());
            pstm.setString(7, cj.getCnpj());
            pstm.execute();
            pstm.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar cliente físico" + e);
        }
        return false;
    }
}