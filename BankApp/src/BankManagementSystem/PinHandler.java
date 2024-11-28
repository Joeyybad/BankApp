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

            // Étape 1 : Vérifier si l'ancien PIN existe dans la table `bank`
            String checkPinQuery = "SELECT pin FROM bank WHERE pin = '" + oldPin + "'";
            ResultSet rs = dbHandler.executeQuery(checkPinQuery);

            if (!rs.next()) {
                System.out.println("Ancien PIN introuvable dans bank.");
                return false;
            }

            System.out.println("Ancien PIN trouvé. Mise à jour avec le nouveau PIN : " + newPin);

            // Étape 2 : Ajuster le PIN pour `signupthree` si nécessaire
            String getSignupThreePinQuery = "SELECT pinnumber FROM signupthree WHERE pinnumber = '" + oldPin + "'";
            ResultSet rsSignupThree = dbHandler.executeQuery(getSignupThreePinQuery);

            if (rsSignupThree.next()) {
                oldPin = rsSignupThree.getString("pinnumber");
                System.out.println("Ancien PIN ajusté pour signupthree : " + oldPin);
            }

            // Étape 3 : Mettre à jour le PIN dans toutes les tables
            String updateBankQuery = "UPDATE bank SET pin = '" + newPin + "' WHERE pin = '" + oldPin + "'";
            boolean bankUpdated = dbHandler.executeUpdate(updateBankQuery);

            String updateSignupThreeQuery = "UPDATE signupthree SET pinnumber = '" + newPin + "' WHERE pinnumber = '" + oldPin + "'";
            boolean signupThreeUpdated = dbHandler.executeUpdate(updateSignupThreeQuery);

            String updateLoginQuery = "UPDATE login SET pinnumber = '" + newPin + "' WHERE pinnumber = '" + oldPin + "'";
            boolean loginUpdated = dbHandler.executeUpdate(updateLoginQuery);

            // Vérifier le succès des mises à jour
            if (bankUpdated && signupThreeUpdated && loginUpdated) {
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
