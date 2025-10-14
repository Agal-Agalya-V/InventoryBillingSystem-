package javaassignment_2;

public class SaleDetail {
    private Product product;
    private int quantity;

    public SaleDetail(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    public double getTax() {
        return getSubtotal() * product.getTaxCategory().getTaxRate();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}

