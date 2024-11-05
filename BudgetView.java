package View;

import Model.Transaction;

import java.util.List;
import java.util.Scanner;

public class BudgetView {
    private Scanner scanner;

    public BudgetView() {
        scanner = new Scanner(System.in);
    }

    public int showMainMenu() {
        System.out.println("\n1. Add Income");
        System.out.println("2. Add Expense");
        System.out.println("3. View Balance");
        System.out.println("4. View Transactions");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }

    public String getTransactionDescription() {
        System.out.print("Enter description: ");
        scanner.nextLine(); // Consume newline
        return scanner.nextLine().trim(); // Trim whitespace
    }

    public double getTransactionAmount() {
        System.out.print("Enter amount: ");
        return scanner.nextDouble();
    }

    public void displayBalance(double balance) {
        System.out.printf("Current balance: $%.2f\n", balance);
    }

    public void displayTransactions(List<Transaction> transactions) {
        if (transactions.isEmpty()) {
            System.out.println("No transactions recorded.");
        } else {
            System.out.println("Transactions:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    public int getStrategyChoice() {
        System.out.println("\nSelect Balance Strategy:");
        System.out.println("1. Simple Balance");
        System.out.println("2. Projected Balance");
        System.out.println("3. Category Summary");
        System.out.print("Enter choice (1-3): ");
        return scanner.nextInt();
    }

    public void displayExitMessage() {
        System.out.println("Exiting...");
    }

    public void displayInvalidOptionMessage() {
        System.out.println("Invalid option. Please try again.");
    }
}
