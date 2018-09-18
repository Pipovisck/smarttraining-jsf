package br.cefetmg.inf.model.db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectaBd {
    private static final String URL = "jdbc:postgresql://localhost:5432/smarttraining";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "123456";
    private static Connection conn;
    
    public static Connection conecta(){
        try {
            Class.forName("org.postgresql.Driver");
            try {
                conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (SQLException ex) {
                Logger.getLogger(ConectaBd.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectaBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
