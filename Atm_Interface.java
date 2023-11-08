import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("\nDeposit of Rs." + amount + " successful. New balance: Rs." + balance);
        } 
        else {
            System.out.println("\nInvalid deposit amount.\n");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance- amount;
            System.out.println("\nWithdrawal of Rs." + amount + " successful. New balance: Rs." + balance);
        } 
        else if (amount > balance) {
            System.out.println("\nInsufficient balance for withdrawal!!\n");
        } 
        else {
            System.out.println("\nInvalid withdrawal amount.\n");
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("\nWelcome to the ATM!");
        System.out.println("\n1. Check Balance");
        System.out.println("\n2. Deposit");
        System.out.println("\n3. Withdraw");
        System.out.println("\n4. Exit");
    }

    public void userChoice(int choice) {
        Scanner scanner = new Scanner(System.in);

        switch (choice) {
            case 1:
                System.out.println("\nYour balance is : Rs." + account.getBalance());
                break;
            case 2:
                System.out.print("\nEnter the deposit amount: Rs.");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                break;
            case 3:
                System.out.print("\nEnter the withdrawal amount: Rs.");
                double withdrawalAmount = scanner.nextDouble();
                account.withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("\nThank you!!\n");
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid choice!!\nPlease select a valid option.\n");
        }
    }
}

public class Atm_Interface {
    public static void main(String[] args) {
        double initialBalance = 100;
        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("\nEnter your choice : ");
            int choice = scanner.nextInt();
            atm.userChoice(choice);
        }
    }
}