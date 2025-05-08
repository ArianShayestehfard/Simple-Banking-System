import java.util.Scanner;

public class BankingSystem {

    private static OpenAccount[] accounts = new OpenAccount[100];
    private static Scanner scanner = new Scanner(System.in);
    private static int accountCounter = 0;
    private static int nextAccountNumber = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println(
                    "\nOpen a Bank Account :(1)" +
                            "\nDeposit money :(2)" +
                            "\nWithdraw money :(3)" +
                            "\nView Account balance :(4)" +
                            "\nExit :(5)");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    viewBalance();
                    break;
                case 5:
                    System.out.println("Exiting system");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static void createAccount() {
        if (accountCounter >= accounts.length) {
            System.out.println("Maximum number of accounts reached");
            return;
        }

        System.out.println("Enter account name:");
        String name = scanner.nextLine();

        System.out.println("Enter password (4 Digits):");
        int password = scanner.nextInt();
        scanner.nextLine();

        int accountNumber = nextAccountNumber++;
        accounts[accountCounter++] = new OpenAccount(name, password, accountNumber);
        System.out.println("Account created");
        System.out.println("Your account number is: " + accountNumber);
    }

    private static OpenAccount findAccount(int accountNumber) {
        for (int i = 0; i < accountCounter; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    private static void depositMoney() {
        if (accountCounter == 0) {
            System.out.println("No accounts exist");
            return;
        }

        System.out.println("Enter account number:");
        int accountNumber = scanner.nextInt();

        OpenAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Enter password:");
        int password = scanner.nextInt();

        if (account.getPassword() != password) {
            System.out.println("Invalid password");
            return;
        }

        System.out.println("Enter currency (1-Rial, 2-Dollar):");
        int currencyChoice = scanner.nextInt();

        System.out.println("Enter amount to deposit:");
        double amount = scanner.nextDouble();

        if (currencyChoice == 1) {
            account.depositRial(amount);
            System.out.println(amount + " Rial deposited.");
        } else if (currencyChoice == 2) {
            account.depositDollar(amount);
            System.out.println(amount + " USD deposited.");
        } else {
            System.out.println("Invalid currency choice");
        }
    }

    private static void withdrawMoney() {
        if (accountCounter == 0) {
            System.out.println("No accounts exist");
            return;
        }

        System.out.println("Enter account number:");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();

        OpenAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Enter password:");
        int password = scanner.nextInt();
        scanner.nextLine();

        if (account.getPassword() != password) {
            System.out.println("Invalid credentials");
            return;
        }

        System.out.println("Choose your currency (Rial/Dollar):");
        String currency = scanner.nextLine();

        if (!currency.equalsIgnoreCase("Rial") && !currency.equalsIgnoreCase("Dollar")) {
            System.out.println("Invalid currency. Please choose Rial or Dollar.");
            return;
        }

        System.out.println("Enter withdrawal amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        boolean success;
        if (currency.equalsIgnoreCase("Rial")) {
            success = account.withdrawRial(amount);
            if (success) {
                System.out.printf("Withdrew %.2f Rial successfully.%n", amount);
            } else {
                System.out.println("Insufficient Rial balance.");
            }
        } else {
            success = account.withdrawDollar(amount);
            if (success) {
                System.out.printf("Withdrew %.2f USD successfully.%n", amount);
            } else {
                System.out.println("Insufficient USD balance.");
            }
        }
    }

    private static void viewBalance() {
        if (accountCounter == 0) {
            System.out.println("No accounts exist");
            return;
        }

        System.out.println("Enter account number:");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();

        OpenAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Enter password:");
        int password = scanner.nextInt();

        if (account.getPassword() == password) {
            account.display();

        } else {
            System.out.println("Invalid credentials");
        }
    }
}
