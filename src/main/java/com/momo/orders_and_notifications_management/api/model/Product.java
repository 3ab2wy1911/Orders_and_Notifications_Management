package com.momo.orders_and_notifications_management.api.model;

public class Product {
    // Attributes
    private int id;
    private String name;
    private double price;

    //----------------------------------------------------------------


    public Product(int id, String name, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    //----------------------------------------------------------------
    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //----------------------------------------------------------------
}
