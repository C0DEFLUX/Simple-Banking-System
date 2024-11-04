import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = null;

        while (true) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Add New Customer");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //Adding a new customer
                    if (customer != null) {
                        System.out.println("An account already exists!");
                    } else {
                        System.out.print("Enter account number: ");
                        String accountNumber = scanner.nextLine();
                        System.out.print("Enter initial balance: ");
                        double initialBalance = scanner.nextDouble();
                        scanner.nextLine();

                        try {
                            customer = new Customer(accountNumber, initialBalance);
                            System.out.println("Customer account created successfully!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    break;

                case 2:
                    //Deposit money
                    if (customer == null) {
                        System.out.println("No customer account exists!");
                    } else {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        customer.deposit(depositAmount);
                    }
                    break;

                case 3:
                    //Withdraw money
                    if (customer == null) {
                        System.out.println("No customer account exists!");
                    } else {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        customer.withdraw(withdrawalAmount);
                    }
                    break;

                case 4:
                    //Check balance
                    if (customer == null) {
                        System.out.println("No customer account exists!");
                    } else {
                        System.out.println("Current Balance: " + customer.getBalance());
                    }
                    break;

                case 5:
                    //Exit the system
                    System.out.println("Exiting.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}