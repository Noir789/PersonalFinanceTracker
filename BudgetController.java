package Controller;

import Model.*;
import View.BudgetView;

public class BudgetController {
private BudgetFacade budgetFacade;
private BudgetView view;
private BalanceStrategy balanceStrategy;

public BudgetController(BudgetView view) {
    this.budgetFacade = new BudgetFacade();
    this.view = view;

    // Register observers for alerts
    BudgetTracker tracker = BudgetTracker.getInstance();
    tracker.addObserver(new LowBalanceAlert(100.00)); // Threshold set to $100
    tracker.addObserver(new NegativeBalanceAlert());

    // Default strategy
    this.balanceStrategy = new SimpleBalanceStrategy();
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
                handleBalanceReport();
                break;
            case 4:
                view.displayTransactions(budgetFacade.getTransactions());
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
        budgetFacade.addIncome(description, amount);
    }

    private void handleAddExpense() {
        String description = view.getTransactionDescription();
        double amount = view.getTransactionAmount();
        budgetFacade.addExpense(description, amount);
    }

private void handleBalanceReport() {
    int strategyChoice = view.getStrategyChoice();

    switch (strategyChoice) {
        case 1:
            this.balanceStrategy = new SimpleBalanceStrategy();
            break;
        case 2:
            this.balanceStrategy = new ProjectedBalanceStrategy(2000, 1500); // example projections
            break;
        case 3:
            this.balanceStrategy = new CategorySummaryStrategy();
            break;
        default:
            System.out.println("Invalid choice. Defaulting to Simple Balance.");
            this.balanceStrategy = new SimpleBalanceStrategy();
    }

    // Display the calculated balance based on the chosen strategy
    double balance = balanceStrategy.calculateBalance(BudgetTracker.getInstance());
    view.displayBalance(balance);
}
}
