package services;

import java.sql.*;

public class MonConnection {

    public MonConnection() {
    }

    public Connection getConnection() throws Exception {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ecole", "responsable", "0");
            con.setAutoCommit(false);
            System.out.println("Connection PostgreSql Succeffuls");
        } catch (ClassNotFoundException | SQLException e) {
            // System.out.println(e.getMessage());
            //throw e;
        }
        return con;
    }
}
