 package pack1;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Bikes bikes = new Bikes();
    static Customers customers = new Customers();
    static Transactions transactions = new Transactions();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Please select an account to use:");
            System.out.println("1 - Owner/Manager");
            System.out.println("2 - Mechanic");
            System.out.println("3 - Exit");
            System.out.print(">> ");
            switch (scanner.nextInt()) {
                case 1:
                    scanner.nextLine();
                    managerChoices();
                    break;
                case 2:
                    scanner.nextLine();
                    manageInventory();
                    break;
                case 3:
                    return;
                default:
                    scanner.nextLine();
                    break;
            }
        }

    }

    public static void managerChoices() {
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1 - Inventory");
            System.out.println("2 - Manage Customers");
            System.out.println("3 - Start Transaction");
            System.out.println("4 - Return Bike");
            System.out.println("5 - Exit");
            System.out.print(">> ");
            switch (scanner.nextInt()) {
                case 1:
                    scanner.nextLine();
                    manageInventory();
                    break;
                case 2:
                    scanner.nextLine();
                    manageCustomers();
                    break;
                case 3:
                    scanner.nextLine();
                    manageTransaction();
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Please input the number of the bike you are returning");
                    System.out.print(">> ");
                    Bike bike = bikes.searchBike(scanner.nextInt());
                    if (bike == null){
                        System.out.println("There is no bike with that number");
                        break;
                    }
                    bike.setBikeStatus("IN");
                    ArrayList<Transaction> bikeTransactions = transactions.searchTransactionsBike(bike.getNumber());
                    Transaction transaction = null;
                    for (Transaction t : bikeTransactions) {
                    	if (!t.isReturned()) {
                    		transaction = t;
                    		break;
                    	}
                    }
                    java.time.LocalDate now = java.time.LocalDate.now();
                    if (now.isAfter(transaction.getEndDate())) {
                    	double price = transaction.getEndDate().until(now).getDays() * bike.getChargeRate();
                    	System.out.println("The customer owes $" + price);
                    	transaction.setCost(transaction.getCost() + price);
                    }
                    transaction.setReturned(true);
                    	
                    break;
                case 5:
                    scanner.nextLine();
                    return;
                default:
                    scanner.nextLine();
                    break;
            }
        }

    }

    public static void manageInventory() {
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1 - Add Bike");
            System.out.println("2 - Delete Bike");
            System.out.println("3 - Edit Bike");
            System.out.println("4 - Print Bike Details");
            System.out.println("5 - Exit");
            System.out.print(">> ");
            switch (scanner.nextInt()) {
                case 1:
                    scanner.nextLine();
                    createBikeUI();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Please input the number of the bike you wish to delete\n>> ");
                    bikes.removeBike(bikes.searchBike(scanner.nextInt()));
                    scanner.nextLine();
                    break;
                case 3:
                    scanner.nextLine();
                    editBikeUI();
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("Please input the number of the bike you wish to print\n>> ");
                    Bike bike = bikes.searchBike(scanner.nextInt());
                    scanner.nextLine();
                    if (bike == null){
                        System.out.println("There are no bikes with that number");
                        break;
                    }
                    bike.print();
                    break;
                case 5:
                    scanner.nextLine();
                    return;
                default:
                    scanner.nextLine();
                    break;
            }
        }

    }

    public static void createBikeUI() {
        Bike newBike = new Bike();
        System.out.print("Please input the bike number\n>> ");
        newBike.setNumber(scanner.nextInt());
        scanner.nextLine();
        if (bikes.searchBike(newBike.getNumber()) != null){
            return;
        }

        System.out.print("Please input the bike type\n>> ");
        newBike.setType(scanner.nextLine().trim());

        System.out.print("Please input the bike size\n>> ");
        newBike.setSize(scanner.nextLine().trim());

        System.out.print("Please input the bike make\n>> ");
        newBike.setMake(scanner.nextLine().trim());

        System.out.print("Please input the bike model\n>> ");
        newBike.setModel(scanner.nextLine().trim());

        System.out.print("Please input the charge rate\n>> ");
        newBike.setChargeRate(scanner.nextDouble());
        scanner.nextLine();

        System.out.print("Please input the deposit price\n>> ");
        newBike.setDeposit(scanner.nextDouble());
        scanner.nextLine();

        while (true) {
            System.out.print("Please input the bike status (IN, OUT, or REPAIRING)\n>> ");
            String status = scanner.nextLine().trim();
            if (status.equals("IN") || status.equals("OUT") || status.equals("REPAIRING")) {
                newBike.setBikeStatus(status);
                break;
            }
            System.out.println(status + " is not a valid option");
        }

        System.out.print("Please input any extra details\n>> ");
        newBike.setExtraDetails(scanner.nextLine().trim());

        bikes.addBike(newBike);
    }

    public static void editBikeUI() {
        System.out.print("Please input the number of the bike you wish to edit\n>> ");
        Bike bike = bikes.searchBike(scanner.nextInt());
        scanner.nextLine();
        if (bike == null) {
            System.out.println("There does not exist a bike with that number");
        }
        while (true) {
            System.out.println("Please select an option");
            System.out.println("1 - Edit Bike number");
            System.out.println("2 - Edit Bike type");
            System.out.println("3 - Edit Bike size");
            System.out.println("4 - Edit Bike make");
            System.out.println("5 - Edit Bike model");
            System.out.println("6 - Edit Charge rate");
            System.out.println("7 - Edit Deposit price");
            System.out.println("8 - Edit Bike Status");
            System.out.println("9 - Edit Extra Details");
            System.out.print("10 - Exit\n>> ");
            switch (scanner.nextInt()) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Please input the bike number\n>> ");
                    bike.setNumber(scanner.nextInt());
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Please input the bike type\n>> ");
                    bike.setType(scanner.nextLine().trim());
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Please input the bike size\n>> ");
                    bike.setSize(scanner.nextLine().trim());
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("Please input the bike make\n>> ");
                    bike.setMake(scanner.nextLine().trim());
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.print("Please input the bike model\n>> ");
                    bike.setModel(scanner.nextLine().trim());
                    break;
                case 6:
                    scanner.nextLine();
                    System.out.print("Please input the charge rate\n>> ");
                    bike.setChargeRate(scanner.nextInt());
                    break;
                case 7:
                    scanner.nextLine();
                    System.out.print("Please input the deposit price\n>> ");
                    bike.setDeposit(scanner.nextDouble());
                    break;
                case 8:
                    scanner.nextLine();
                    while (true) {
                        System.out.print("Please input the bike status (IN, OUT, or REPAIRING)\n>> ");
                        String status = scanner.nextLine().trim();
                        if (status.equals("IN") || status.equals("OUT") || status.equals("REPAIRING")) {
                            bike.setBikeStatus(status);
                            break;
                        }
                        System.out.println(status + " is not a valid option");
                    }
                    break;
                case 9:
                    scanner.nextLine();
                    System.out.print("Please input the extra details\n>> ");
                    bike.setExtraDetails(scanner.nextLine().trim());
                    break;
                case 10:
                    scanner.nextLine();
                    return;
                default:
                    scanner.nextLine();
                    System.out.println("That is not a valid option");
                    break;
            }
        }
    }

    public static void manageCustomers() {
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1 - Add Customer");
            System.out.println("2 - Remove Customer");
            System.out.println("3 - Edit Customer");
            System.out.println("4 - Print Customer Transactions");
            System.out.println("5 - Exit");
            switch (scanner.nextInt()) {
                case 1:
                    scanner.nextLine();
                    createCustomerUI();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Please input the name of the Customer you wish to remove\n>> ");
                    customers.removeCustomer(customers.searchCustomer(scanner.nextLine().trim()));
                    break;
                case 3:
                    scanner.nextLine();
                    editCustomerUI();
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("Please input the name of the Customer\n>> ");
                    ArrayList<Transaction> customerTransactions;
                    customerTransactions = transactions.searchTransactionsCustomer(scanner.nextLine().trim());
                    if (customerTransactions.isEmpty()) {
                        System.out.println("There are no transactions with that customer");
                        break;
                    }
                    for (Transaction t : customerTransactions) {
                        t.print();
                    }
                    break;
                case 5:
                    scanner.nextLine();
                    return;
                default:
                    scanner.nextLine();
                    break;
            }
        }
    }

    public static void createCustomerUI() {
        Customer newCustomer = new Customer();
        System.out.print("Please input the customer's name\n>> ");
        newCustomer.setName(scanner.nextLine().trim());

        System.out.print("Please input the customer's address\n>> ");
        newCustomer.setAddress(scanner.nextLine().trim());

        System.out.print("Please input the customer's telephone number\n>> ");
        newCustomer.setTelephone(scanner.nextLine().trim());

        customers.addCustomer(newCustomer);
    }

    public static void editCustomerUI() {
        System.out.print("Please input the name of the customer you wish to edit\n>> ");
        Customer customer = customers.searchCustomer(scanner.nextLine().trim());
        if (customer == null) {
            System.out.println("There does not exist a customer with that name");
        }

        while (true) {
            System.out.println("Please select an option");
            System.out.println("1 - Edit the customer's name");
            System.out.println("2 - Edit the customer's address");
            System.out.println("3 - Edit the customer's telephone number");
            System.out.print("4 - Exit\n>> ");
            switch (scanner.nextInt()) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Please input the customer's name\n>> ");
                    customer.setName(scanner.nextLine().trim());
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Please input the customer's address\n>> ");
                    customer.setAddress(scanner.nextLine().trim());
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Please input the customer's telephone number\n>> ");
                    customer.setTelephone(scanner.nextLine().trim());
                    break;
                case 4:
                    scanner.nextLine();
                    return;
                default:
                    scanner.nextLine();
                    System.out.println("That is not a valid option");
                    break;
            }
        }
    }

    public static void manageTransaction() {
        System.out.println("Please enter the bike number");
        Transaction newTransaction = new Transaction();
        Bike bike = bikes.searchBike(scanner.nextInt());
        scanner.nextLine();
        if (bike == null) {
            System.out.println("There is no bike with that number");
            return;
        }
        bike.print();
        if (!bike.getBikeStatus().equals("IN")){
            System.out.println("That bike is not available");
            return;
        }
        newTransaction.setBikeNumber(bike.getNumber());
        System.out.print("Please enter the hire length in days\n>> ");
        newTransaction.setStartDate(java.time.LocalDate.now());
        long hireTime = scanner.nextLong();
        scanner.nextLine();
        newTransaction.setEndDate(newTransaction.getStartDate().plusDays(hireTime));

        double totalCost = hireTime * bike.getChargeRate() + bike.getDeposit();
        System.out.println("Total cost :" + hireTime + " x $" + bike.getChargeRate() + " + $" + bike.getDeposit()
                + " = $" + totalCost);
        System.out.print("Please enter the customer's name\n>> ");
        newTransaction.setCustomer(scanner.nextLine().trim());
        if (customers.searchCustomer(newTransaction.getCustomer()) == null) {
            Customer newCustomer = new Customer();
            newCustomer.setName(newTransaction.getCustomer());

            System.out.print("Please input the customer's address\n>> ");
            newCustomer.setAddress(scanner.nextLine().trim());

            System.out.print("Please input the customer's telephone number\n>> ");
            newCustomer.setTelephone(scanner.nextLine().trim());
            customers.addCustomer(newCustomer);
        }
        newTransaction.setCost(totalCost);
        newTransaction.setReturned(false);
        System.out.print("Enter 1 if the customer paid or 2 to cancel the transaction\n>> ");
        switch (scanner.nextInt()) {
            case 1:
                scanner.nextLine();
                bike.setBikeStatus("OUT");
                transactions.addTransaction(newTransaction);
                System.out.print(
                        "Enter 1 to print a receipt, 2 to add more transactions, or 3 to not print a receipt\n>> ");
                switch (scanner.nextInt()) {
                    case 1:
                        scanner.nextLine();
                        ArrayList<Transaction> customerTransactions = transactions
                                .searchTransactionsCustomer(newTransaction.getCustomer());
                        for (Transaction t : customerTransactions) {
                            if (!t.isReturned()) {
                                t.print();
                            }
                        }
                        break;
                    case 2:
                        scanner.nextLine();
                        manageTransaction();
                        break;
                    default:
                        scanner.nextLine();
                        break;
                }
                break;
            default:
                scanner.nextLine();
                break;
        }
    }
}
