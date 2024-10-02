package java_folder;


import java.util.*;

public class assignment1 {
    private static double balance=1000.00;
    private static int pin =1234;
    private static ArrayList<String> transactionHistory = new ArrayList<>();
    private static void balanceInquiry() 
    {
        System.out.println("Current balance: $" + balance);
        transactionHistory.add("Balance Inquiry: $" + balance);
    }

    private static void cashWithdrawal(Scanner sc) 
    {
        System.out.print("Enter withdrawal amount: $");
        double amount = sc.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
            transactionHistory.add("Withdrawal: $" + amount);
        }
    }

    private static void cashDeposit(Scanner sc) 
    {
        System.out.print("Enter deposit amount: $");
        double amount = sc.nextDouble();

        balance += amount;
        System.out.println("Deposit successful. New balance: $" + balance);
        transactionHistory.add("Deposit: $" + amount);
    }

    private static void changePIN(Scanner sc)
    {
        System.out.print("Enter new PIN: ");
        int newPIN = sc.nextInt();

        pin = newPIN;
        System.out.println("PIN successfully changed.");
        transactionHistory.add("PIN Change");
    }

    private static void displayTransactionHistory()
    {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your PIN: ");
        int enterpin=sc.nextInt();
        if(enterpin==pin)
        {
            int option =0;
            while(option!=6)
            {
                System.out.println("\nATM Menu:");
                System.out.println("1. Balance Inquiry");
                System.out.println("2. Cash Withdrawal");
                System.out.println("3. Cash Deposit");
                System.out.println("4. Change PIN");
                System.out.println("5. Transaction History");
                System.out.println("6. Exit");

                System.out.print("Choose an option: ");
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        balanceInquiry();
                        break;
                    case 2:
                        cashWithdrawal(sc);
                        break;
                    case 3:
                        cashDeposit(sc);
                        break;
                    case 4:
                        changePIN(sc);
                        break;
                    case 5:
                        displayTransactionHistory();
                        break;
                    case 6:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
        else
        {
            System.out.println("Incorrect PIN. Please try again.");
        }
        sc.close();
    }
}

