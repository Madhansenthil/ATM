import java.util.Scanner;

public class ATM {

    static Scanner scanner = new Scanner(System.in);
    static double balance = 1000.00;

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = readMenuChoice();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    System.out.println("\nThank you for using the ATM!");
                    break;
            }

        } while (choice != 4);

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n===== CONSOLE ATM =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public static int readMenuChoice() {
        while (true) {
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                if (choice >= 1 && choice <= 4) {
                    return choice;
                }

                System.out.println("Please enter a number between 1 and 4.");
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }

    public static void checkBalance() {
        System.out.printf("Current Balance: ₹%.2f%n", balance);
    }

    public static void deposit() {
        double amount = readPositiveAmount("Enter deposit amount: ₹");

        balance += amount;

        System.out.printf("₹%.2f deposited successfully.%n", amount);
        checkBalance();
    }

    public static void withdraw() {
        double amount = readPositiveAmount("Enter withdrawal amount: ₹");

        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal cancelled.");
            return;
        }

        balance -= amount;

        System.out.printf("₹%.2f withdrawn successfully.%n", amount);
        checkBalance();
    }

    public static double readPositiveAmount(String message) {
        while (true) {
            System.out.print(message);

            if (scanner.hasNextDouble()) {
                double amount = scanner.nextDouble();

                if (amount > 0) {
                    return amount;
                }

                System.out.println("Amount must be greater than zero.");
            } else {
                System.out.println("Invalid input. Please enter a valid amount.");
                scanner.next();
            }
        }
    }
}