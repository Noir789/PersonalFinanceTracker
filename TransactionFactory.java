package Model;

public interface TransactionFactory {
    Transaction createTransaction(String description, double amount);
}
