import java.util.Scanner;

// Class to represent user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid amount. Please enter a positive number.");
            return false;
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
            return false;
        } else {
            balance -= amount;
            System.out.println("✅ Withdrawal successful. ₹" + amount + " has been withdrawn.");
            return true;
        }
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid amount. Please enter a positive number.");
            return false;
        } else {
            balance += amount;
            System.out.println("✅ Deposit successful. ₹" + amount + " has been deposited.");
            return true;
        }
    }

    public void checkBalance() {
        System.out.printf("💰 Current Balance: ₹%.2f\n", balance);
    }
}

// Class to represent ATM machine
class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        int choice;

        System.out.println("===== Welcome to the ATM =====");

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    handleWithdrawal();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("👋 Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("⚠️ Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }

    private void handleWithdrawal() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }
}

// Main class to run the ATM
public class ATMInterface {
    public static void main(String[] args) {
        // Create a bank account with initial balance ₹10,000
        BankAccount userAccount = new BankAccount(10000.0);

        // Create and start ATM session
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
