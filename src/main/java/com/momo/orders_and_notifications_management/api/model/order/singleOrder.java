package com.momo.orders_and_notifications_management.api.model.order;

import java.util.ArrayList;
import java.util.List;

public class singleOrder extends Order{
    // Attributes for single order only...
    List <Order> orderList;

    //----------------------------------------------------------------
    public singleOrder() {
        orderList = new ArrayList<Order>();
        this.customerId = -1;
    }
    //----------------------------------------------------------------
    public singleOrder(int customerId){
        this.customerId = customerId;
    }
    //----------------------------------------------------------------

}
