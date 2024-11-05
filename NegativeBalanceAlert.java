package Model;

public class NegativeBalanceAlert implements BalanceObserver {
    @Override
    public void update(double balance) {
        if (balance < 0) {
            System.out.println("Warning: Balance is negative! Current balance: $" + balance);
        }
    }
}
