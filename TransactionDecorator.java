package Decorator;

import Model.Transaction;

abstract class TransactionDecorator extends Transaction {
    protected Transaction transaction;

    public TransactionDecorator(Transaction transaction) {
        super(transaction.description, transaction.getAmount());
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return transaction.toString();
    }
}