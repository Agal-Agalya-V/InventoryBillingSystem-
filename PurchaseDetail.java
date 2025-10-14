package javaassignment_2;

public class PurchaseDetail {
    private Product product;
    private int quantity;

    // Constructor
    public PurchaseDetail(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getter for product
    public Product getProduct() {
        return product;
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // Calculate subtotal
    public double getSubtotal() {
        return product.getPrice() * quantity;
    }
}
