package BankManagementSystem;

import java.sql.ResultSet;

public class BalanceHandler {
    private final DatabaseHandler dbHandler;

    public BalanceHandler(DatabaseHandler dbHandler) {
        if (dbHandler == null) {
            throw new IllegalArgumentException("DatabaseHandler ne peut pas être null.");
        }
        this.dbHandler = dbHandler;
    }

    /**
     * Méthode pour récupérer le solde actuel.
     *
     * @param pin Le PIN de l'utilisateur.
     * @return Le solde actuel.
     */
    public double getBalance(String pin) {
        try {
            String balanceQuery = "SELECT balance FROM bank WHERE pin = ? ORDER BY date DESC LIMIT 1";
            ResultSet rs = dbHandler.executeQuery(balanceQuery, pin);

            if (rs.next()) {
                return rs.getDouble("balance");
            } else {
                throw new RuntimeException("Aucune transaction trouvée pour cet utilisateur.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération du solde : " + e.getMessage(), e);
        }
    }
}
