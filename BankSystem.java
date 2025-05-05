import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("variz anjam shod");
        } else {
            System.out.println("mablagh namotabar");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("bardasht anjam shod");
        } else {
            System.out.println("mojodi kafi nist");
        }
    }

    public void checkBalance() {
        System.out.println(" mojodi" + balance + " toman");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

public class BankSystem {
    private static Map<String, Account> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n*system banki*");
            System.out.println("1.ejad hesab");
            System.out.println("2. variz vajh");
            System.out.println("3.bardashte vajh");
            System.out.println("4. mojodi");
            System.out.println("5. khoroj");
            System.out.print("entekhab shoma: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositToAccount();
                    break;
                case 3:
                    withdrawFromAccount();
                    break;
                case 4:
                    checkAccountBalance();
                    break;
                case 5:
                    System.out.println("khoroje az system");
                    break;
                default:
                    System.out.println("entekhab namotabar");
            }
        } while (choice != 5);
    }

    private static void createAccount() {
        System.out.print("shomare hesab");
        String accNum = scanner.nextLine();
        System.out.print("naam saaheb hesab");
        String name = scanner.nextLine();

        if (accounts.containsKey(accNum)) {
            System.out.println("in shomare hesab ghablan sabt shode");
        } else {
            accounts.put(accNum, new Account(accNum, name));
            System.out.println("hesab ijaad shod");
        }
    }

    private static void depositToAccount() {
        System.out.print("shomare hesab: ");
        String accNum = scanner.nextLine();
        Account account = accounts.get(accNum);
        if (account != null) {
            System.out.print("mablagh variz: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            account.deposit(amount);
        } else {
            System.out.println("hesab yaft nashod");
        }
    }

    private static void withdrawFromAccount() {
        System.out.print("shomare hesab:");
        String accNum = scanner.nextLine();
        Account account = accounts.get(accNum);
        if (account != null) {
            System.out.print("mablagh bardasht:");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            account.withdraw(amount);
        } else {
            System.out.println("hesab yaaft nashod");
        }
    }
    private static void checkAccountBalance() {
        System.out.print("shomare hedsab: ");
        String accNum = scanner.nextLine();
        Account account = accounts.get(accNum);
        if (account != null) {
            account.checkBalance();
        } else {
            System.out.println("hesab yaaft nashod");
        }
    }
}