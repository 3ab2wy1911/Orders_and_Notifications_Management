package com.momo.orders_and_notifications_management.api.model;

public class NotificationRequest {


    int orderId;
    private String typeOfChannel="";

    public NotificationRequest(){

    }

    public int getOrderId() {
        return orderId;
    }

    public String getTypeOfChannel() {
        return typeOfChannel;
    }

}
