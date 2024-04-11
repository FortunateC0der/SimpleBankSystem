import java.util.Scanner;

class BankAccount {
    int balance, preTransaction;
    String custName, custId;

    BankAccount(String cname, String cid) {
        custName = cname;
        custId = cid;
    }

    void deposit(int amt) {
        if (amt != 0) {
            balance = balance + amt;
            preTransaction = amt;
        }
    }

    void withdraw(int amt) {
        if (amt != 0) {
            balance = balance - amt;
            preTransaction = -amt;
        }
    }

    void getPreTransaction() {
        if (preTransaction > 0) {
            System.out.println("Deposited: " + preTransaction);
        } else if (preTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(preTransaction));
        } else {
            System.out.println("No transaction took place!");
        }
    }

    void menuBar() {
        Scanner sc = new Scanner(System.in);
        char option;

        do {
            System.out.println("A. Check Bank Balance\nB. Deposit Cash\nC. Withdraw Cash\nD. View Previous Transaction\nE. Exit");
            System.out.println("***********************************");
            System.out.println("Choose your option");
            System.out.println("***********************************");
            option = sc.next().charAt(0);

            switch (option) {
                case 'A':
                    System.out.println("Your balance is: " + balance);
                    break;
                case 'B':
                    System.out.println("Enter amount you want to deposit: ");
                    int amt = sc.nextInt();
                    deposit(amt);
                    break;
                case 'C':
                    System.out.println("How much do you want to withdraw? ");
                    int amt2 = sc.nextInt();
                    withdraw(amt2);
                    break;
                case 'D':
                    getPreTransaction();
                    break;
                case 'E':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Option! Please try again.");
            }
        } while (option != 'E');
        sc.close();
    }
}

    public class SimpleBankSys {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("John Doe", "12345");
        account.menuBar();
    }
}
