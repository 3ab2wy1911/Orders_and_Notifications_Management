package com.momo.orders_and_notifications_management.api.model.order;

import com.momo.orders_and_notifications_management.api.model.Product;

public class SingleOrder extends Order{
    // Attributes for single order only...
    Product product;

    //----------------------------------------------------------------
    public SingleOrder() {
        this.product = null;
        this.customerId = -1;
    }
    //----------------------------------------------------------------
    public SingleOrder(int customerId, Product product){
        this.product = product;
        this.customerId = customerId;
    }
    //----------------------------------------------------------------

}
