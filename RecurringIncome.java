package Decorator;

import Model.Transaction;

class RecurringIncome extends TransactionDecorator {
    public RecurringIncome(Transaction transaction) {
        super(transaction);
    }

    @Override
    public String toString() {
        return transaction.toString() + " (Recurring)";
    }
}