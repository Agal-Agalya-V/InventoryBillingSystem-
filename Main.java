package javaassignment_2;

import java.util.*;

public class Main {
    static Map<String, Product> products = new HashMap<>();
    static Map<String, Customer> customers = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Product\n2. Add Customer\n3. Make Purchase\n4. Make Sale\n5. Display Products\n6. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> addCustomer();
                case 3 -> makePurchase();
                case 4 -> makeSale();
                case 5 -> displayProducts();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void addProduct() {
        System.out.print("Product ID: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Quantity: ");
        int qty = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Tax Category Name: ");
        String cat = sc.nextLine();
        System.out.print("Tax Rate(in %): ");
        int rate = sc.nextInt()/100;
        sc.nextLine(); 

        ProductTaxCategory ptc = new ProductTaxCategory(cat, rate);
        Product p = new Product(id, name, price, qty, ptc);
        products.put(id, p);
        System.out.println("Product added.");
    }

    static void addCustomer() {
        System.out.print("Customer ID: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Is Premium (yes/no)? ");
        String type = sc.nextLine();
        Customer c = type.equalsIgnoreCase("yes") ? new PremiumCustomer(id, name) : new Customer(id, name);
        customers.put(id, c);
        System.out.println("Customer added.");
    }

    static void makePurchase() {
        Purchase purchase = new Purchase();
        while (true) {
            System.out.print("Product ID (or 'done'): ");
            String pid = sc.nextLine();
            if (pid.equalsIgnoreCase("done")) break;

            Product p = products.get(pid);
            if (p == null) {
                System.out.println("Product not found.");
                continue;
            }

            System.out.print("Quantity to purchase: ");
            int qty = sc.nextInt();
            sc.nextLine(); 

            purchase.addDetail(new PurchaseDetail(p, qty));
        }
        purchase.processPurchase();
    }

    static void makeSale() {
        System.out.print("Customer ID: ");
        String cid = sc.nextLine();
        Customer c = customers.get(cid);
        if (c == null) {
            System.out.println("Customer not found.");
            return;
        }

        Sale sale = new Sale(c);
        while (true) {
            System.out.print("Product ID (or 'done'): ");
            String pid = sc.nextLine();
            if (pid.equalsIgnoreCase("done")) break;

            Product p = products.get(pid);
            if (p == null) {
                System.out.println("Product not found.");
                continue;
            }

            System.out.print("Quantity: ");
            int qty = sc.nextInt();
            sc.nextLine(); // consume newline

            sale.addDetail(new SaleDetail(p, qty));
        }
        sale.processSale();
    }

    static void displayProducts() {
        System.out.println("\n--- Product List ---");
        for (Product p : products.values()) {
            System.out.println(p.getName() + " | ₹" + p.getPrice() + " | Qty: " + p.getQuantity());
        }
    }
}
