package com.momo.orders_and_notifications_management.api.model.order;

public class singleOrder extends Order{
    // Attributes for single order only...
    int productId;

    //----------------------------------------------------------------
    public singleOrder() {
        this.customerId = -1;
        this.productId = -1;
    }
    //----------------------------------------------------------------
    public singleOrder(int customerId, int productId){
        this.customerId = customerId;
        this.productId = productId;
    }
}
