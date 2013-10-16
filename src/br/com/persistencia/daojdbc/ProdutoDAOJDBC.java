package br.com.persistencia.daojdbc;

import br.com.model.Produto;
import br.com.persistencia.dao.ProdutoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutoDAOJDBC {

    //implements: ligar os comandos (salvar, remover, editar...) ao clienteDAO
//onde o clienteDAO liga ao banco de dados. fazendo assim o armazenamento.
    public class ProdutoDAOJDBC implements ProdutoDAO {

        private static final String DELETE = "";
        private static final String LIST = "";
        private static final String LISTBYID = "";
        private static final String INSERT = "";
        private static final String UPDATE = "";

        @Override
        public boolean salvar(Produto p) throws SQLException {
            if (p.getId() == 0) {
                return inserir(p);
            } else {
                return editar(p);
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
        public List<Produto> listarTodos() {
            Connection conn;
            List<Produto> produto = new ArrayList<>();
            try {
                conn = ConnectionFactory.getConnection();
                PreparedStatement pstm = conn.prepareStatement(LIST);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    Produto p = new Produto();
                    p.setId(rs.getInt("codigo"));
                    p.setNome(rs.getString("nome"));
                    p.setDataCadastro(rs.getDate("dataCadastro"));
                    p.setTelefoneContato1(rs.getString("telefoneContato1"));
                    p.setTelefoneContato2(rs.getString("telefoneContato2"));
                    p.setEmail(rs.getString("email"));
                    p.setEndereco(rs.getInt("endereco"));
                    p.setCpf(rs.getString("cpf"));
                    p.setRg(rs.getString("rg"));
                    produto.add(p);

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao listar o cliente físico: " + ex);
            }
            return produto;
        }

        @Override
        public Produto listarId(int id) {
            Connection conn;
            try {
                conn = ConnectionFactory.getConnection();
                PreparedStatement pstm = conn.prepareStatement(LISTBYID);
                pstm.setInt(1, id);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    Produto p = new Produto();
                    p.setId(rs.getInt("codigo"));
                    p.setNome(rs.getString("nome"));
                    p.setDataCadastro(rs.getDate("dataCadastro"));
                    p.setTelefoneContato1(rs.getString("telefoneContato1"));
                    p.setTelefoneContato2(rs.getString("telefoneContato2"));
                    p.setEmail(rs.getString("email"));
                    p.setEndereco(rs.getInt("endereco"));
                    p.setCpf(rs.getString("cpf"));
                    p.setRg(rs.getString("rg"));
                    return p;
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao listar cliente físico" + e);
            }
            return null;
        }

        private boolean inserir(Produto p) throws SQLException {
            Connection conn = null;
            try {
                conn = ConnectionFactory.getConnection();
                PreparedStatement pstm = conn.prepareStatement(INSERT);
                pstm.setString(1, p.getNome());
                pstm.setDate(2, new java.sql.Date(p.getDataCadastro().getTime()));
                pstm.setString(3, p.getTelefoneContato1());
                pstm.setString(4, p.getTelefoneContato2());
                pstm.setString(5, p.getEmail());
                pstm.setInt(6, p.getEndereco());
                pstm.setString(7, p.getCpf());
                pstm.setString(8, p.getRg());
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

        private boolean editar(Produto p) {

            Connection conn;
            try {
                conn = ConnectionFactory.getConnection();
                PreparedStatement pstm = conn.prepareStatement(UPDATE);

                pstm.setString(1, p.getNome());
                pstm.setDate(2, new java.sql.Date(p.getDataCadastro().getTime()));
                pstm.setString(3, p.getTelefoneContato1());
                pstm.setString(4, p.getTelefoneContato2());
                pstm.setString(5, p.getEmail());
                pstm.setInt(6, p.getEndereco());
                pstm.setString(7, p.getCpf());
                pstm.setString(8, p.getRg());
                pstm.execute();
                pstm.close();
                conn.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao editar cliente físico" + e);
            }
            return false;
        }
    }
}