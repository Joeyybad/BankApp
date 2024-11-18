package BankManagementSystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class DepositHandlerTest {

    // Méthode pour obtenir une connexion à la base de données de test
    private Connection getTestConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/banktest"; // Base de test
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }

    @Test
    void testInsertDeposit() {
        String pin = "1234";
        String date = "2024-10-16 10:30:00";
        String amount = "500";

        try (Connection testConnection = getTestConnection()) {
            // Initialisation de DatabaseHandler et DepositHandler
            DatabaseHandler dbHandler = new DatabaseHandler(testConnection);
            DepositHandler depositHandler = new DepositHandler(dbHandler);

            // Nettoyage avant le test
            try (Statement stmt = testConnection.createStatement()) {
                stmt.execute("DELETE FROM bank WHERE pin = '" + pin + "'");
            }

            // Appel de la méthode à tester
            boolean result = depositHandler.insertDeposit(pin, date, amount);

            // Vérifications
            assertTrue(result, "La méthode insertDeposit devrait retourner true.");

            // Vérification en base de données
            try (Statement stmt = testConnection.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
                assertTrue(rs.next(), "Les données devraient être insérées dans la table.");
                assertEquals(amount, rs.getString("amount"), "Le montant inséré ne correspond pas.");
                assertEquals("Deposit", rs.getString("type"), "Le type inséré ne correspond pas.");
            }

        } catch (Exception e) {
            fail("Le test a échoué à cause d'une exception : " + e.getMessage());
        } finally {
            try (Connection testConnection = getTestConnection()) {
                // Nettoyage après le test
                try (Statement stmt = testConnection.createStatement()) {
                    stmt.execute("DELETE FROM bank WHERE pin = '" + pin + "'");
                }
            } catch (Exception e) {
                System.err.println("Erreur lors du nettoyage de la base de données : " + e.getMessage());
            }
        }
    }
}


