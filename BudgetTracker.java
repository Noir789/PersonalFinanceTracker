package Model;

import java.util.ArrayList;
import java.util.List;

public class BudgetTracker {
    private static BudgetTracker instance;
    private List<Transaction> transactions;
    private List<BalanceObserver> observers;

    private BudgetTracker() {
        transactions = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static synchronized BudgetTracker getInstance() {
        if (instance == null) {
            instance = new BudgetTracker();
        }
        return instance;
    }

    public void addObserver(BalanceObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BalanceObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        double balance = getBalance();
        for (BalanceObserver observer : observers) {
            observer.update(balance);
        }
    }

    public void addIncome(String description, double amount) {
        transactions.add(new Income(description, amount));
        notifyObservers();
    }

    public void addExpense(String description, double amount) {
        transactions.add(new Expense(description, amount));
        notifyObservers();
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