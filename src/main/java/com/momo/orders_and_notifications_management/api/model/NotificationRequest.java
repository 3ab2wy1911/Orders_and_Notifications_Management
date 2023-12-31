package com.momo.orders_and_notifications_management.api.model;

public class NotificationRequest {


    private String productName;
    private String customerName;
    private String typeOfChannel;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTypeOfChannel() {
        return typeOfChannel;
    }

    public void setTypeOfChannel(String typeOfChannel) {
        this.typeOfChannel = typeOfChannel;
    }
}
