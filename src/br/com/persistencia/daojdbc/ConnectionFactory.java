package br.com.persistencia.daojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionFactory {
    
    //liga o programa ao bando de dados. ("" = dados do banco)
    private static final String STR_CONEXAO = "";
    private static final String DATABASE = "";
    private static final String USER = "";
    private static final String PASSWORD = "";

    //cria o comando para conectar ao banco. 
    //"Connection" é comando pronto do JAVA 
    public static Connection getConnection() throws SQLException {

        try {
            return DriverManager.getConnection(STR_CONEXAO + DATABASE, USER, PASSWORD);
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }
}