package br.com.persistencia.daojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

    // String conexão com o banco mySQL
    private static final String STR_CONEXAO = "jdbc:mysql://localhost:3306/";
    // nome da base de dados criada no mySQL
    private static final String DATABASE = "projetolavanderiaav2";
    // usuário do mySQL 
    private static final String USER = "root";
    // senha do mySQL
    private static final String PASSWORD = "";

    // método que retorna a conexão
    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(STR_CONEXAO + DATABASE, USER, PASSWORD);
        } catch (Exception ex) {
            throw new SQLException(ex.getMessage());
        }
    }

// metodo que fecha a conexão 
    public static void closeConnection(Connection con) throws SQLException {
        if (con != null) {
            con.close();
        }
    }

//fecha o statement
    public static void closeConnection(Connection con, Statement stmt) throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
        closeConnection(con);
    }

    // metodo fecha o resultSet
    public static void closeConnection(Connection con, Statement stmt, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        closeConnection(con, stmt);
    }
}