package model;

public class Customer {
    private String customerId;
    private String name;

    public Customer(String id, String name) {
        this.customerId = id;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String toString() {
        return customerId + " - " + name;
    }
}