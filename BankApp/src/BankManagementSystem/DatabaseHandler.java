package BankManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseHandler {
    private final Connection connection;

    // Constructeur prenant une connexion en paramètre
    public DatabaseHandler(Connection connection) {
        if (connection == null) {
            throw new IllegalArgumentException("La connexion ne peut pas être nulle.");
        }
        this.connection = connection;
    }

    // Méthode générique pour exécuter une mise à jour (INSERT, UPDATE, DELETE)
    public boolean executeUpdate(String query, Object... params) {
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'exécution de la mise à jour : " + e.getMessage(), e);
        }
    }

    // Méthode générique pour exécuter une requête (SELECT)
    public ResultSet executeQuery(String query, Object... params) {
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            return stmt.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'exécution de la requête : " + e.getMessage(), e);
        }
    }
}
