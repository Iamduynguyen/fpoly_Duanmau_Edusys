/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;

/**
 *
 * @author dell
 */
public class Dbconnection {
    private final static String user = "duy";
    private final static String pw = "a";
    private final static String dbname = "abc";
    private final static String hostname = "127.0.0.1";
    private final static String connectionURL = "jdbc:sqlserver://" + hostname
            + ":1433;databaseName=" + dbname;
    private static Connection  conn;

    public Dbconnection() {
    }
    
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
    
    public static Connection getConnection(){
        if (conn==null) {
            try {
                openConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
        public static void openConnection() throws ClassNotFoundException, SQLException {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionURL, user, pw);
    }
}
