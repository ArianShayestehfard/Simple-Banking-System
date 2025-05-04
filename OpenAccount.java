public class OpenAccount {

    private String accountName;
    private int accountNumber;
    private int password;
    private double balanceRial;
    private double balanceDollar;

    public OpenAccount(String accountName, int password, int accountNumber) {
        this.accountName = accountName;
        this.password = password;
        this.accountNumber = accountNumber;
        this.balanceRial = 0;
        this.balanceDollar = 0;
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

    public double getBalanceRial() {
        return balanceRial;
    }

    public double getBalanceDollar() {
        return balanceDollar;
    }

    public void depositRial(double amount) {
        if (amount > 0)  {
            balanceRial += amount;
        }
        else {
            System.out.println("Amount must be greater than zero.");
        }
    }

    public void depositDollar(double amount) {
        if (amount > 0) {
        balanceDollar += amount;}
        else {
            System.out.println("Amount must be greater than zero.");
        }
    }

    public boolean withdrawRial(double amount) {
        if (balanceRial >= amount) {
            balanceRial -= amount;
            return true;
        }
        return false;
    }

    public boolean withdrawDollar(double amount) {
        if (balanceDollar >= amount) {
            balanceDollar -= amount;
            return true;
        }
        return false;
    }

    public void display() {
        System.out.println(
                "Account Name: " + accountName +
                        "\nAccount Number: " + accountNumber +
                        "\nAccount Balance in Rial: " + balanceRial +
                        "\nAccount Balance in USD: " + "$" + balanceDollar);
    }
}
