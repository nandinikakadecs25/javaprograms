import java.util.*;

class Account {
    String customerName;
    String accountNumber;
    String accountType;
    double balance;

    Account(String name, String accNo, String type, double balance) {
        this.customerName = name;
        this.accountNumber = accNo;
        this.accountType = type;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited: " + amount);
        displayBalance();
    }

    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

class SavAcct extends Account {
    final double INTEREST_RATE = 0.05; 

    SavAcct(String name, String accNo, double balance) {
        super(name, accNo, "Savings", balance);
    }

    void computeAndDepositInterest(int years) {
        double interest = balance * Math.pow((1 + INTEREST_RATE), years) - balance;
        balance += interest;
        System.out.println("Interest of " + interest + " added for " + years + " years.");
        displayBalance();
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        }
        displayBalance();
    }
}

class CurAcct extends Account {
    final double MIN_BALANCE = 1000.0;
    final double SERVICE_CHARGE = 100.0;

    CurAcct(String name, String accNo, double balance) {
        super(name, accNo, "Current", balance);
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        }

        checkMinimumBalance();
        displayBalance();
    }

    void checkMinimumBalance() {
        if (balance < MIN_BALANCE) {
            balance -= SERVICE_CHARGE;
            System.out.println("Balance below minimum! Service charge of " + SERVICE_CHARGE + " imposed.");
        }
    }
}

public class BankApp { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SavAcct savings = new SavAcct("Alice", "S1001", 5000);
        CurAcct current = new CurAcct("Bob", "C2001", 2000);

        int choice;
        do {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Deposit to Savings");
            System.out.println("2. Withdraw from Savings");
            System.out.println("3. Compute Interest on Savings");
            System.out.println("4. Deposit to Current");
            System.out.println("5. Withdraw from Current");
            System.out.println("6. Display Balances");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    savings.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    savings.withdraw(sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter number of years: ");
                    savings.computeAndDepositInterest(sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter amount to deposit: ");
                    current.deposit(sc.nextDouble());
                    break;
                case 5:
                    System.out.print("Enter amount to withdraw: ");
                    current.withdraw(sc.nextDouble());
                    break;
                case 6:
                    System.out.println("\n--- Account Balances ---");
                    System.out.print("Savings - ");
                    savings.displayBalance();
                    System.out.print("Current - ");
                    current.displayBalance();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);

        sc.close();
    }
}

