package javaassignment_2;

public class ProductTaxCategory {
    private String categoryName;
    private double taxRate;

    public ProductTaxCategory(String categoryName, double taxRate) {
        this.categoryName = categoryName;
        this.taxRate = taxRate;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

