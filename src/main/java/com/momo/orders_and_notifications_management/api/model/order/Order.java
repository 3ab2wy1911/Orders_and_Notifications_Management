package com.momo.orders_and_notifications_management.api.model.order;

public abstract class Order {
    // common attributes
    int customerId;
    int orderId;
    String type;

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //----------------------------------------------------------------
    public int getCustomerId() {
        return customerId;
    }

    //----------------------------------------------------------------
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
