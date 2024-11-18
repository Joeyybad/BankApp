package BankManagementSystem;

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
        if (amount == null || amount.isEmpty()) {
            throw new IllegalArgumentException("Le montant ne peut pas être vide.");
        }
        String query = "INSERT INTO bank (pin, date, type, amount) VALUES(?, ?, ?, ?)";
        return dbHandler.executeUpdate(query, pin, date, "Deposit", amount);
    }
}