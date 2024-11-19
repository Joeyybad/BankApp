package BankManagementSystem;

import java.sql.ResultSet;

public class WithdrawHandler {
    private final DatabaseHandler dbHandler;

    public WithdrawHandler(DatabaseHandler dbHandler) {
        if (dbHandler == null) {
            throw new IllegalArgumentException("DatabaseHandler ne peut pas être null.");
        }
        this.dbHandler = dbHandler;
    }

    public boolean withdraw(String pin, String date, String amount) {
        try {
            // Récupérer le solde actuel
            String queryBalance = "SELECT balance FROM bank WHERE pin = ? ORDER BY date DESC LIMIT 1";
            ResultSet rs = dbHandler.executeQuery(queryBalance, pin);

            int currentBalance = 0;
            if (rs.next()) {
                currentBalance = rs.getInt("balance");
            }

            // Vérifier si le solde est suffisant
            int withdrawAmount = Integer.parseInt(amount);
            if (currentBalance < withdrawAmount) {
                throw new RuntimeException("Solde insuffisant pour effectuer ce retrait.");
            }

            // Calculer le nouveau solde
            int newBalance = currentBalance - withdrawAmount;

            // Insérer la transaction avec le nouveau solde
            String queryInsert = "INSERT INTO bank (pin, date, type, amount, balance) VALUES (?, ?, ?, ?, ?)";
            return dbHandler.executeUpdate(queryInsert, pin, date, "Withdrawl", amount, newBalance);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors du retrait : " + e.getMessage(), e);
        }
    }
}
