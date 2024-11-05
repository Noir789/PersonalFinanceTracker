package Model;

public class ProjectedBalanceStrategy implements BalanceStrategy {
    private double monthlyIncomeProjection;
    private double monthlyExpenseProjection;

    public ProjectedBalanceStrategy(double monthlyIncomeProjection, double monthlyExpenseProjection) {
        this.monthlyIncomeProjection = monthlyIncomeProjection;
        this.monthlyExpenseProjection = monthlyExpenseProjection;
    }

    @Override
    public double calculateBalance(BudgetTracker tracker) {
        return tracker.getBalance() + (monthlyIncomeProjection - monthlyExpenseProjection);
    }
}