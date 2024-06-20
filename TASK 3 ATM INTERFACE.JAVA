import java.util.Scanner;

// BankAccount class to handle balance operations
class BankAccount {
    private double balance;

    // Constructor to initialize the balance
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit an amount to the balance
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw an amount from the balance
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

// ATM class to provide an interface for user interactions
class ATM {
    private BankAccount account;

    // Constructor to initialize the ATM with a BankAccount
    public ATM(BankAccount bankAccount) {
        account = bankAccount;
    }

    // Method to display the ATM menu
    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    // Method to run the ATM interface
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Display balance
                    System.out.println("Your balance: Rs. " + account.getBalance());
                    break;
                case 2:
                    // Deposit amount
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful. Your balance: Rs. " + account.getBalance());
                    break;
                case 3:
                    // Withdraw amount
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Your balance: Rs. " + account.getBalance());
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 4:
                    // Exit ATM
                    System.out.println("Thank you for using the ATM!");
                    scanner.close();
                    return;
                default:
                    // Invalid option
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
}

// Main class to start the ATM application
public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
