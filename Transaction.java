package Model;


public class Transaction {
    public String description;
    protected double amount;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return description + ": $" + amount;
    }
}
