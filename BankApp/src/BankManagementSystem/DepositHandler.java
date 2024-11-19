package BankManagementSystem;

import java.sql.ResultSet;

public class DepositHandler {
    private final DatabaseHandler dbHandler;

    // Constructeur prenant DatabaseHandler comme dépendance
    public DepositHandler(DatabaseHandler dbHandler) {
        if (dbHandler == null) {
            throw new IllegalArgumentException("DatabaseHandler ne peut pas être nul.");
        }
        this.dbHandler = dbHandler;
    }

    // Méthode pour insérer un dépôt
    public boolean insertDeposit(String pin, String date, String amount) {
        try {
            // Récupérer le solde actuel
            String queryBalance = "SELECT balance FROM bank WHERE pin = ? ORDER BY date DESC LIMIT 1";
            ResultSet rs = dbHandler.executeQuery(queryBalance, pin);

            int currentBalance = 0;
            if (rs.next()) {
                currentBalance = rs.getInt("balance");
            }

            // Calculer le nouveau solde
            int depositAmount = Integer.parseInt(amount);
            int newBalance = currentBalance + depositAmount;

            // Insérer la transaction avec le nouveau solde
            String queryInsert = "INSERT INTO bank (pin, date, type, amount, balance) VALUES (?, ?, ?, ?, ?)";
            return dbHandler.executeUpdate(queryInsert, pin, date,"Deposit", amount, newBalance);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'insertion du dépôt : " + e.getMessage(), e);
        }
    }

}