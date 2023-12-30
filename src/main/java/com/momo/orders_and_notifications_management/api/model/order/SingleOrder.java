package com.momo.orders_and_notifications_management.api.model.order;

import com.momo.orders_and_notifications_management.api.model.Product;
import com.momo.orders_and_notifications_management.api.model.order.print_order_details.PrintSingleOrder;

public class SingleOrder extends Order{
    // Attributes for single order only...
    Product product;

    //----------------------------------------------------------------
    public SingleOrder() {
        this.product = null;
        this.customerId = -1;
        this.type = "Single Order";
        this.printDetails = new PrintSingleOrder();
    }
    //----------------------------------------------------------------
    public SingleOrder(int customerId, Product product){
        this.product = product;
        this.customerId = customerId;
        this.type = "Single Order";
        this.printDetails = new PrintSingleOrder();
    }
    //----------------------------------------------------------------


}
