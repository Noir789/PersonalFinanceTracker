package Model;

public class ExpenseFactory implements TransactionFactory {
    @Override
    public Transaction createTransaction(String description, double amount) {
        return new Expense(description, amount);
    }
}
