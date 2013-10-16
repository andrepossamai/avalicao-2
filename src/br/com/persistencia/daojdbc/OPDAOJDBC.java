package br.com.persistencia.daojdbc;

import br.com.model.OP;
import br.com.persistencia.dao.OPDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//implements: ligar os comandos (salvar, remover, editar...) ao clienteDAO
//onde o clienteDAO liga ao banco de dados. fazendo assim o armazenamento.
public class OPDAOJDBC implements OPDAO {

    private static final String DELETE = "";
    private static final String LIST = "";
    private static final String LISTBYID = "";
    private static final String INSERT = "";
    private static final String UPDATE = "";

        public boolean salvar(OP op) throws SQLException {
        if (op.getId() == 0) {
            return inserir(op);
        } else {
            return editar(op);
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
            JOptionPane.showMessageDialog(null, "Erro ao excluir uma OP" + e);
            return false;
        }
    }

    @Override
        public List<OP> listarTodos() {
        Connection conn;
        List<OP> op = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LIST);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                OP op = new OP();
                op.setId(rs.getInt("codigo"));
                op.setCliente(rs.getString("cliente"));
                op.setFuncionario(rs.getString("funcionario"));
                op.setServico(rs.getString("servico"));
                op.setNumeropecas(rs.getInt("numeroPecas"));
                op.setLote(rs.getString("lote"));
                op.add(op);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar OP " + ex);
        }
        return op;
    }

    @Override
        public OP listarId(int id) {
        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                OP op = new OP();
                op.setId(rs.getInt("codigo"));
                op.setCliente(rs.getString("cliente"));
                op.setFuncionario(rs.getString("funcionario"));
                op.setServico(rs.getString("servico"));
                op.setNumeropecas(rs.getInt("numeroPecas"));
                op.setLote(rs.getString("lote"));
                return op;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar OP " + e);
        }
        return null;
    }

    private boolean inserir(OP op) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);

            pstm.setString(1, op.getCliente());
            pstm.setString(2, op.getFuncionario());
            pstm.setString(3, op.getServico());
            pstm.setInt(4, op.getNumeropecas());
            pstm.setString(5, op.getLote());
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

    private boolean editar(OP op) {

        Connection conn;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);

            pstm.setString(1, op.getCliente());
            pstm.setString(2, op.getFuncionario());
            pstm.setString(3, op.getServico());
            pstm.setInt(4, op.getNumeropecas());
            pstm.setString(5, op.getLote());
            pstm.execute();
            pstm.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar OP" + e);
        }
        return false;
    }
  
}