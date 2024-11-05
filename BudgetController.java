package Controller;

import Model.BudgetTracker;
import View.BudgetView;

public class BudgetController {
    private BudgetTracker model;
    private BudgetView view;

    public BudgetController(BudgetTracker model, BudgetView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        boolean running = true;
        while (running) {
            int choice = view.showMainMenu();
            switch (choice) {
                case 1:
                    handleAddIncome();
                    break;
                case 2:
                    handleAddExpense();
                    break;
                case 3:
                    view.displayBalance(model.getBalance());
                    break;
                case 4:
                    view.displayTransactions(model.getTransactions());
                    break;
                case 5:
                    view.displayExitMessage();
                    running = false;
                    break;
                default:
                    view.displayInvalidOptionMessage();
            }
        }
    }

    private void handleAddIncome() {
        String description = view.getTransactionDescription();
        double amount = view.getTransactionAmount();
        model.addIncome(description, amount);
    }

    private void handleAddExpense() {
        String description = view.getTransactionDescription();
        double amount = view.getTransactionAmount();
        model.addExpense(description, amount);
    }
}

