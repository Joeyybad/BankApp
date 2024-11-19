package BankManagementSystem;

import java.sql.ResultSet;

public class FastCashHandler {
    private final DatabaseHandler dbHandler;

    public FastCashHandler(DatabaseHandler dbHandler) {
        if (dbHandler == null) {
            throw new IllegalArgumentException("DatabaseHandler ne peut pas être null.");
        }
        this.dbHandler = dbHandler;
    }

    /**
     * Méthode pour effectuer un retrait rapide.
     *
     * @param pin    Le PIN de l'utilisateur.
     * @param date   La date du retrait.
     * @param amount Le montant à retirer.
     * @return true si le retrait rapide a réussi, false sinon.
     */
    public boolean withdrawFastCash(String pin, String date, String amount) {
        try {
            // Récupérer le solde actuel
            String balanceQuery = "SELECT balance FROM bank WHERE pin = ? ORDER BY date DESC LIMIT 1";
            ResultSet rs = dbHandler.executeQuery(balanceQuery, pin);
            double currentBalance = 0;

            if (rs.next()) {
                currentBalance = rs.getDouble("balance");
            }

            double withdrawAmount = Double.parseDouble(amount);

            // Vérifier si le solde est suffisant
            if (withdrawAmount > currentBalance) {
                throw new RuntimeException("Solde insuffisant pour effectuer le retrait rapide.");
            }

            // Calculer le nouveau solde
            double newBalance = currentBalance - withdrawAmount;

            // Insérer la transaction avec le nouveau solde
            String insertQuery = "INSERT INTO bank (pin, date, type, amount, balance) VALUES (?, ?, 'Withdrawal', ?, ?)";
            return dbHandler.executeUpdate(insertQuery, pin, date, -withdrawAmount, newBalance);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors du retrait rapide : " + e.getMessage(), e);
        }
    }
}
