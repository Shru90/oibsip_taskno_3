import java.util.Scanner;

public class App {
    private static final String USER_ID = "12345";
    private static final String USER_PIN = "54321";

    private static double balance = 1000.0; // Initial balance for demonstration purposes

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;

        // Prompt user for user id and pin
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        // Check user id and pin
        if (userId.equals(USER_ID) && pin.equals(USER_PIN)) {
            loggedIn = true;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid user id or pin. Exiting...");
            System.exit(0);
        }

        // ATM functionalities
        while (loggedIn) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    showTransactionsHistory();
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    transfer(scanner);
                    break;
                case 5:
                    loggedIn = false;
                    System.out.println("Logged out successfully. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. View Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
        System.out.print("Enter your choice: ");
    }

    private static void showTransactionsHistory() {
        System.out.println("Transaction History:");
        // Implement logic to retrieve and display transaction history from a database or file
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Updated balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Updated balance: $" + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private static void transfer(Scanner scanner) {
        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        if (amount > 0 && amount <= balance) {
            System.out.print("Enter the recipient's account number: ");
            String recipientAccount = scanner.nextLine();

            // Implement logic to perform the transfer to the recipient's account
            // Update balances accordingly
            // Display appropriate messages
            System.out.println("Transfer successful. Updated balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }
}