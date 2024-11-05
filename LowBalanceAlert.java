package Model;

public class LowBalanceAlert implements BalanceObserver {
    private double threshold;

    public LowBalanceAlert(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public void update(double balance) {
        if (balance < threshold) {
            System.out.println("Alert: Balance is below threshold! Current balance: $" + balance);
        }
    }
}
