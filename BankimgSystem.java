abstract class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolderName, double balance, double overdraftLimit) {
        super(accountNumber, accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= -overdraftLimit) {
            balance -= amount;
        } else {
            System.out.println("Exceeds overdraft limit!");
        }
    }
}

class Main {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("SA123", "John Doe", 1000.0, 0.02);
        CheckingAccount checkingAccount = new CheckingAccount("CA456", "Jane Smith", 1500.0, 500.0);

        System.out.println("Savings Account:");
        System.out.println("Account Holder: " + savingsAccount.getAccountHolderName());
        System.out.println("Initial Balance: $" + savingsAccount.getBalance());
        savingsAccount.deposit(500.0);
        System.out.println("After Deposit: $" + savingsAccount.getBalance());
        savingsAccount.withdraw(200.0);
        System.out.println("After Withdrawal: $" + savingsAccount.getBalance());

        System.out.println("\nChecking Account:");
        System.out.println("Account Holder: " + checkingAccount.getAccountHolderName());
        System.out.println("Initial Balance: $" + checkingAccount.getBalance());
        checkingAccount.deposit(300.0);
        System.out.println("After Deposit: $" + checkingAccount.getBalance());
        checkingAccount.withdraw(2000.0);
        System.out.println("After Withdrawal: $" + checkingAccount.getBalance());
    }
}
