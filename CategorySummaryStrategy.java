package Model;

public class CategorySummaryStrategy implements BalanceStrategy {
    @Override
    public double calculateBalance(BudgetTracker tracker) {
        System.out.println("Category Summary:");
        tracker.getTransactions().forEach(System.out::println);
        return tracker.getBalance();
    }
}