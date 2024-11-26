package BankManagementSystem;

import java.sql.ResultSet;

public class PinHandler {

    private final DatabaseHandler dbHandler;

    // Constructeur prenant DatabaseHandler comme dépendance
    public PinHandler(DatabaseHandler dbHandler) {
        if (dbHandler == null) {
            throw new IllegalArgumentException("DatabaseHandler ne peut pas être nul.");
        }
        this.dbHandler = dbHandler;
    }

    // Méthode pour changer le PIN
    public boolean pinChange(String oldPin, String newPin) {
        try {
            System.out.println("Vérification de l'ancien PIN : " + oldPin);

            // Vérification de l'ancien PIN dans la table 'bank'
            String checkPinQuery = "SELECT pin FROM bank WHERE pin = '" + oldPin + "'"; 
            ResultSet rs = dbHandler.executeQuery(checkPinQuery);

            if (!rs.next()) {
                System.out.println("Ancien PIN introuvable.");
                throw new RuntimeException("L'ancien PIN est incorrect.");
            }

            System.out.println("Ancien PIN trouvé. Mise à jour avec le nouveau PIN : " + newPin);

            // Mise à jour du PIN dans la table 'bank'
            String updatePinQuery = "UPDATE bank SET pin = '" + newPin + "' WHERE pin = '" + oldPin + "'";
            boolean bankUpdated = dbHandler.executeUpdate(updatePinQuery);

            // Mise à jour du PIN dans la table 'login'
            String updatePinQuery2 = "UPDATE login SET pin = '" + newPin + "' WHERE pin = '" + oldPin + "'";
            boolean loginUpdated = dbHandler.executeUpdate(updatePinQuery2);

            // Mise à jour du PIN dans la table 'signupthree'
            String updatePinQuery3 = "UPDATE signupthree SET pin = '" + newPin + "' WHERE pin = '" + oldPin + "'";
            boolean signupUpdated = dbHandler.executeUpdate(updatePinQuery3);

            // Si toutes les mises à jour sont réussies
            if (bankUpdated && loginUpdated && signupUpdated) {
                System.out.println("PIN mis à jour avec succès dans toutes les tables.");
                return true;
            } else {
                System.out.println("Échec de la mise à jour du PIN dans une ou plusieurs tables.");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Erreur lors du changement de PIN : " + e.getMessage());
            return false;
        }
    }
}
