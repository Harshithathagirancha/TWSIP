import java.util.Scanner;

public class ATM {
    private static double balance = 1000; // Initial balance
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to the ATM!");

        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Withdraw cash");
            System.out.println("2. Check account balance");
            System.out.println("3. Deposit money");
            System.out.println("4. Transfer funds");
            System.out.println("5. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    withdrawCash();
                    break;
                case 2:
                    checkBalance();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    transferFunds();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close(); // Close the scanner before exiting
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void withdrawCash() {

        System.out.println("Enter the amount to withdraw:");
        double amount = scanner.nextDouble();

        if (amount > balance || amount < 0) {
            System.out.println("Invalid amount or insufficient funds. Please try again.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: $" + balance);
        }
    }

    private static void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    private static void depositMoney() {

        System.out.println("Enter the amount to deposit:");
        double amount = scanner.nextDouble();

        if (amount < 0) {
            System.out.println("Invalid amount. Please try again.");
        } else {
            balance += amount;
            System.out.println("Deposit successful. Current balance: $" + balance);
        }
    }

    private static void transferFunds() {

        System.out.println("Enter the amount to transfer:");
        double amount = scanner.nextDouble();

        if (amount > balance || amount < 0) {
            System.out.println("Invalid amount or insufficient funds. Please try again.");
        } else {
            balance -= amount;
            System.out.println("Transfer successful. Current balance: $" + balance);
        }
    }
}
