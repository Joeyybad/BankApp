package BankManagementSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.junit.jupiter.api.Test;

class PinChangeTest {

    private Connection getTestConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/BankApp_Test"; // Base de test
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }

    @Test
    void testPinChange() throws Exception {
        // Connexion à la base de données
        Connection testConnection = getTestConnection();
        DatabaseHandler dbHandler = new DatabaseHandler(testConnection);
        PinHandler pinHandler = new PinHandler(dbHandler);

        // Étape 1 : Récupérer un ancien PIN existant dans la table `signupthree`
        String oldPin = null;
        ResultSet rs = dbHandler.executeQuery("SELECT pinnumber FROM signupthree LIMIT 1");
        if (rs.next()) {
            oldPin = rs.getString("pinnumber");
            System.out.println("Ancien PIN récupéré pour le test : " + oldPin);
        } else {
            fail("Aucun PIN trouvé dans la table 'signupthree'. Veuillez ajouter des données de test.");
        }

        // Étape 2 : Nouveau PIN à tester
        String newPin = "5678";

        // Étape 3 : Effectuer le changement de PIN
        boolean result = pinHandler.pinChange(oldPin, newPin);

        // Logs pour voir ce qui se passe
        System.out.println("Changement de PIN réussi ? " + result);

        // Vérifier la mise à jour dans `signupthree`
        ResultSet verifySignupThree = dbHandler.executeQuery("SELECT * FROM signupthree WHERE pinnumber = '" + newPin + "'");
        assertTrue(verifySignupThree.next(), "Le PIN dans la table 'signupthree' n'a pas été mis à jour.");

        System.out.println("Test réussi pour signupthree !");
    }


}

