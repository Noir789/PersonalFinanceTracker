package Controller;

import Model.BudgetTracker;
import Model.Transaction;

import java.util.List;

public class BudgetFacade {
    private BudgetTracker tracker;

    public BudgetFacade() {
        this.tracker = BudgetTracker.getInstance();
    }

    public void addIncome(String description, double amount) {
        tracker.addIncome(description, amount);
    }

    public void addExpense(String description, double amount) {
        tracker.addExpense(description, amount);
    }


    public List<Transaction> getTransactions() {
        return tracker.getTransactions();
    }
}
