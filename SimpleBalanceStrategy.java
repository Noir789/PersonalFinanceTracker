package Model;

public class SimpleBalanceStrategy implements BalanceStrategy {
    @Override
    public double calculateBalance(BudgetTracker tracker) {
        return tracker.getBalance();
    }
}
