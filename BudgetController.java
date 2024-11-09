package Controller;

import Decorator.HighValueTransaction;
import Decorator.RecurringIncome;
import Model.*;
import View.BudgetView;

public class BudgetController {
    private BudgetFacade budgetFacade;
    private BudgetView view;
    private BalanceStrategy balanceStrategy;

    public BudgetController(BudgetView view) {
        this.budgetFacade = new BudgetFacade();
        this.view = view;

        BudgetTracker tracker = BudgetTracker.getInstance();
        tracker.addObserver(new LowBalanceAlert(100.00));
        tracker.addObserver(new NegativeBalanceAlert());

        this.balanceStrategy = new SimpleBalanceStrategy();
    }

    public void run() {
        boolean running = true;
        while (running) {
            int choice = view.showMainMenu();
            switch (choice) {
                case 1 -> handleAddTransaction(new IncomeFactory());
                case 2 -> handleAddTransaction(new ExpenseFactory());
                case 3 -> handleBalanceReport();
                case 4 -> view.displayTransactions(budgetFacade.getTransactions());
                case 5 -> {
                    view.displayExitMessage();
                    running = false;
                }
                default -> view.displayInvalidOptionMessage();
            }
        }
    }

    private void handleAddTransaction(TransactionFactory factory) {
        String description = view.getTransactionDescription();
        double amount = view.getTransactionAmount();
        Transaction transaction = factory.createTransaction(description, amount);

        // Применяем декоратор на основе выбора пользователя
        transaction = applyDecorator(transaction);

        // Добавляем транзакцию в систему
        if (transaction instanceof Income) {
            budgetFacade.addIncome(transaction.toString(), transaction.getAmount());
        } else if (transaction instanceof Expense) {
            budgetFacade.addExpense(transaction.toString(), transaction.getAmount());
        }
    }

    private Transaction applyDecorator(Transaction transaction) {
        int decoratorChoice = view.getDecoratorChoice();

        switch (decoratorChoice) {
            case 1 -> transaction = new RecurringIncome(transaction);
            case 2 -> transaction = new HighValueTransaction(transaction);
            default -> System.out.println("No decorator applied.");
        }

        return transaction;
    }

    private void handleBalanceReport() {
        int strategyChoice = view.getStrategyChoice();

        switch (strategyChoice) {
            case 1 -> this.balanceStrategy = new SimpleBalanceStrategy();
            case 2 -> this.balanceStrategy = new ProjectedBalanceStrategy(2000, 1500);
            case 3 -> this.balanceStrategy = new CategorySummaryStrategy();
            default -> {
                System.out.println("Invalid choice. Defaulting to Simple Balance.");
                this.balanceStrategy = new SimpleBalanceStrategy();
            }
        }

        double balance = balanceStrategy.calculateBalance(BudgetTracker.getInstance());
        view.displayBalance(balance);
    }
}
