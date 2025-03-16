package LR_2;

interface BankAccountInterface {
    void deposit(double amount);
    boolean withdraw(double amount);
    double getBalance();
}

// Класс Банковский Счет (BankAccount)
class BankAccount implements BankAccountInterface {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount + ". New balance: $" + balance);
            return true;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "BankAccount{accountNumber='" + accountNumber + "', balance=$" + balance + "}";
    }
}

public class Example7 {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("12345678", 1000.0);
        System.out.println(myAccount);


        myAccount.deposit(500.0);
        myAccount.withdraw(200.0);
        myAccount.withdraw(2000.0);


        System.out.println("Final balance: $" + myAccount.getBalance());
    }
}
