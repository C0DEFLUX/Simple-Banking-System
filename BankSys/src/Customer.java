public class Customer {
    private String accountNumber;
    private double balance;

    //Constructor for Customer
    public Customer(String accountNumber, double initialBalance)
    {
        setAccountNumber(accountNumber);
        setBalance(initialBalance);
    }

    //Getter for account number
    public String getAccountNumber()
    {
        return accountNumber;
    }

    //Setter for accountNumber with validation
    public void setAccountNumber(String accountNumber)
    {
        if (accountNumber == null || accountNumber.isEmpty())
        {
            throw new IllegalArgumentException("Account number cannot be empty.");
        }
        this.accountNumber = accountNumber;
    }

    //Getter for balance
    public double getBalance()
    {
        return balance;
    }

    //Setter for balance with validation
    private void setBalance(double balance)
    {
        if (balance < 0)
        {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = balance;
    }

    //Method to deposit money into the account
    public void deposit(double amount)
    {
        if (amount <= 0)
        {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Successfully deposited: " + amount);
    }

    //Method to withdraw money from the account
    public void withdraw(double amount)
    {
        if (amount <= 0)
        {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance)
        {
            System.out.println("Insufficient funds for this withdrawal.");
            return;
        }
        balance -= amount;
        System.out.println("Successfully withdrew: " + amount);
    }
}
