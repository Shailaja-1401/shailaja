import java.util.Scanner;

class atm {
    private double balance;

    // Constructor to initialize the bank account with an initial balance
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    // Method to get the balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}

class ATM {
    private BankAccount account;

    // Constructor to initialize the ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display the ATM menu and process user options
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    scanner.close();  // Close the scanner to prevent resource leak
                    return; // Exit the ATM
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    // Method to check the balance
    private void checkBalance() {
        System.out.println("Your balance is: $" + account.getBalance());
    }

    // Method to handle deposit operation
    private void deposit(Scanner scanner) {
        System.out.print("Enter deposit amount: $");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposited $" + amount + " successfully.");
    }

    // Method to handle withdrawal operation
    private void withdraw(Scanner scanner) {
        System.out.print("Enter withdrawal amount: $");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrew $" + amount + " successfully.");
        }
    }
}

public class atm{
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);  // Initial balance of $1000
        ATM atm = new ATM(account);  // Initialize ATM with user's account
        atm.displayMenu();  // Display the ATM interface
    }
}
