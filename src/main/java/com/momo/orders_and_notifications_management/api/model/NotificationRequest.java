package com.momo.orders_and_notifications_management.api.model;

public class NotificationRequest {


    int orderId;
    private String typeOfChannel;

    public NotificationRequest(String productName, int orderId) {
        this.orderId = orderId;
        this.typeOfChannel = typeOfChannel;
    }
    public NotificationRequest(){

    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getTypeOfChannel() {
        return typeOfChannel;
    }

    public void setTypeOfChannel(String typeOfChannel) {
        this.typeOfChannel = typeOfChannel;
    }
}
