package Model;

public class IncomeFactory implements TransactionFactory {
    @Override
    public Transaction createTransaction(String description, double amount) {
        return new Income(description, amount);
    }
}
