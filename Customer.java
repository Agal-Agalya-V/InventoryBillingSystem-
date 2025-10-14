package javaassignment_2;
public class Customer {
    protected String id;
    protected String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean isPremium() {
        return false;
    }

    public String getName() {
        return name;
    }
}

