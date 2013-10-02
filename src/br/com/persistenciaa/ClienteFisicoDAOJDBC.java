package br.com.persistenciaa;

import br.com.model.ClienteFisico;
import br.com.persistencia.dao.ClienteFisicoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//implements: ligar os comandos (salvar, remover, editar...) ao clienteDAO
//onde o clienteDAO liga ao banco de dados. fazendo assim o armazenamento.
public class ClienteFisicoDAOJDBC implements ClienteFisicoDAO {

    private static final String DELETE = "";
    private static final String LIST = "";
    private static final String LISTBYID = "";
    private static final String INSERT = "";
    private static final String UPDATE = "";

    @Override
    public boolean salvar(ClienteFisico cf) throws SQLException {
        if (cf.getId() == 0) {
            return inserir(cf);
        } else {
            return editar(cf);
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
    public List<ClienteFisico> listarTodos() {
        Connection conn;
        List<ClienteFisico> clienteFisico = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ClienteFisico cf = new ClienteFisico();
                cf.setId(rs.getInt("codigo"));
                cf.setNome(rs.getString("nome"));
                cf.setDataCadastro(rs.getDate("dataCadastro"));
                cf.setTelefoneContato1(rs.getString("telefoneContato1"));
                cf.setTelefoneContato2(rs.getString("telefoneContato2"));
                cf.setEmail(rs.getString("email"));
                cf.setEndereco(rs.getInt("endereço"));
                cf.setCpf(rs.getString("cpf"));
                cf.setRg(rs.getString("rg"));
                clienteFisico.add(cf);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o cliente físico: " + ex);
        }
        return clienteFisico;
    }

    @Override
    public ClienteFisico listarId(int id) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ClienteFisico cf = new ClienteFisico();
                cf.setId(rs.getInt("codigo"));
                cf.setNome(rs.getString("nome"));
                cf.setDataCadastro(rs.getDate("dataCadastro"));
                cf.setTelefoneContato1(rs.getString("telefoneContato1"));
                cf.setTelefoneContato2(rs.getString("telefoneContato2"));
                cf.setEmail(rs.getString("email"));
                cf.setEndereco(rs.getInt("endereço"));
                cf.setCpf(rs.getString("cpf"));
                cf.setRg(rs.getString("rg"));
                return cf;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar cliente físico" + e);
        }
        return null;
    }

    private boolean inserir(ClienteFisico cf) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);
            pstm.setString(1, cf.getNome());
            pstm.setDate(2, new java.sql.Date(cf.getDataCadastro().getTime()));
            pstm.setString(3, cf.getTelefoneContato1());
            pstm.setString(4, cf.getTelefoneContato2());
            pstm.setString(5, cf.getEmail());
            pstm.setInt(6, cf.getEndereco());
            pstm.setString(7, cf.getCpf());
            pstm.setString(8, cf.getRg());
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

    private boolean editar(ClienteFisico cf) {

        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);

            pstm.setString(1, cf.getNome());
            pstm.setDate(2, new java.sql.Date(cf.getDataCadastro().getTime()));
            pstm.setString(3, cf.getTelefoneContato1());
            pstm.setString(4, cf.getTelefoneContato2());
            pstm.setString(5, cf.getEmail());
            pstm.setInt(6, cf.getEndereco());
            pstm.setString(7, cf.getCpf());
            pstm.setString(8, cf.getRg());
            pstm.execute();
            pstm.close();
            conn.close();
          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar cliente físico" + e);
        }
        return false;
    }
}