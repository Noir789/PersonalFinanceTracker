package Decorator;

import Decorator.TransactionDecorator;
import Model.Transaction;

public class HighValueTransaction extends TransactionDecorator {
    public HighValueTransaction(Transaction transaction) {
        super(transaction);
    }

    @Override
    public String toString() {
        return transaction.toString() + " (High Value)";
    }
}