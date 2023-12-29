package com.momo.orders_and_notifications_management.api.model;
import com.momo.orders_and_notifications_management.api.model.order.Order;

public class Customer {
    // Attributes of the customer...
    private int id;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private double balance;
    private Cart cart;

    public Customer(int id, String name, String address, String email, String phoneNumber, double balance) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        cart = new Cart();
    }

    //================================================================
    // Setters & getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        cart = cart;
    }

    //================================================================
    public void updateCart(Order order){
        cart.update(order);
    }

}
