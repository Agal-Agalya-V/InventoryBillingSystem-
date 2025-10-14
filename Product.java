package javaassignment_2;

public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private ProductTaxCategory taxCategory;

    public Product(String id, String name, double price, int quantity, ProductTaxCategory taxCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.taxCategory = taxCategory;
    }

    public void updateStock(int change) {
        this.quantity += change;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public ProductTaxCategory getTaxCategory() {
        return taxCategory;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
