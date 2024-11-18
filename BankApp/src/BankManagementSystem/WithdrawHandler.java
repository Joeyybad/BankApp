package BankManagementSystem;

public class WithdrawHandler {
    private final DatabaseHandler dbHandler;

    public WithdrawHandler(DatabaseHandler dbHandler) {
        if (dbHandler == null) {
            throw new IllegalArgumentException("DatabaseHandler ne peut pas être null.");
        }
        this.dbHandler = dbHandler;
    }

    public boolean withdraw(String pin, String date, String amount) {
        if (amount == null || amount.isEmpty()) {
            throw new IllegalArgumentException("Le montant ne peut pas être vide.");
        }

        try {
            // Vérifier si le solde est suffisant
            String balanceQuery = "SELECT SUM(CASE WHEN type = 'Deposit' THEN amount ELSE -amount END) AS balance FROM bank WHERE pin = ?";
            var resultSet = dbHandler.executeQuery(balanceQuery, pin);
            if (resultSet.next()) {
                double balance = resultSet.getDouble("balance");
                double withdrawAmount = Double.parseDouble(amount);

                if (withdrawAmount > balance) {
                    throw new RuntimeException("Fonds insuffisants pour effectuer le retrait.");
                }
            } else {
                throw new RuntimeException("Aucun compte associé au PIN fourni.");
            }

            // Insérer le retrait
            String query = "INSERT INTO bank (pin, date, type, amount) VALUES (?, ?, 'Withdrawal', ?)";
            return dbHandler.executeUpdate(query, pin, date, -Double.parseDouble(amount));

        } catch (Exception e) {
            throw new RuntimeException("Erreur lors du retrait : " + e.getMessage(), e);
        }
    }
}
