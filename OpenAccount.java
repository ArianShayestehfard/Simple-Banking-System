public class OpenAccount {

    private String accountName;
    private int accountNumber;
    private int password;
    private double balance;

    public OpenAccount(String accountName, int password, int accountNumber) {
        this.accountName = accountName;
        this.password = password;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public String getAccountName() {
        return accountName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void display() {
        System.out.println(
                "Account Name: " + accountName +
                        "\nAccount Number: " + accountNumber +
                        "\nAccount Balance: " + balance);
    }
}
