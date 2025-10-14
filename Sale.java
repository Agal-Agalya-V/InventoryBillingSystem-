package javaassignment_2;import java.util.*;

public class Sale {
    private Customer customer;
    private List<SaleDetail> details = new ArrayList<>();

    public Sale(Customer customer) {
        this.customer = customer;
    }

    public void addDetail(SaleDetail detail) {
        details.add(detail);
    }

    public void processSale() {
        double total = 0, tax = 0, discount = 0;

        for (SaleDetail detail : details) {
            Product p = detail.getProduct();
            if (p.getQuantity() < detail.getQuantity()) {
                System.out.println("Insufficient stock for " + p.getName());
                return;
            }
        }

        for (SaleDetail detail : details) {
            Product p = detail.getProduct();
            p.updateStock(-detail.getQuantity());
            total += detail.getSubtotal();
            tax += detail.getTax();
        }

        if (customer.isPremium()) {
            PremiumCustomer pc = (PremiumCustomer) customer;
            pc.addPoints(total);
            discount = pc.applyDiscount();
        }

        double finalAmount = total + tax - discount;
        System.out.println("\n--- Sale Bill ---");
        for (SaleDetail detail : details) {
            System.out.println(detail.getProduct().getName() + " x " + detail.getQuantity() + " = ₹" + detail.getSubtotal());
        }
        System.out.println("Tax: ₹" + tax);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Total: ₹" + finalAmount);
        if (customer.isPremium()) {
            System.out.println("Reward Points: " + ((PremiumCustomer) customer).getRewardPoints());
        }
    }
}
