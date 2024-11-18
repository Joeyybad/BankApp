package BankManagementSystem;

import java.sql.*;

public class Conn {

    public Connection c;
    public Statement s;

    public Conn() {
        // Connexion par défaut (base de production)
        this("jdbc:mysql://localhost:3306/BankApp", "root", "root");
    }

    public Conn(String url, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url, username, password);
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println("Erreur de connexion : " + e);
        }
    }
}