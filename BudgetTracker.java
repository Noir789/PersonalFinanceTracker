package Model;

import java.util.ArrayList;
import java.util.List;

public class BudgetTracker {
    private List<Transaction> transactions;

    public BudgetTracker() {
        transactions = new ArrayList<>();
    }

    public void addIncome(String description, double amount) {
        transactions.add(new Income(description, amount));
    }

    public void addExpense(String description, double amount) {
        transactions.add(new Expense(description, amount));
    }

    public double getBalance() {
        double income = transactions.stream()
                .filter(t -> t instanceof Income)
                .mapToDouble(Transaction::getAmount)
                .sum();
        double expense = transactions.stream()
                .filter(t -> t instanceof Expense)
                .mapToDouble(Transaction::getAmount)
                .sum();
        return income - expense;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
