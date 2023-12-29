package com.momo.orders_and_notifications_management.api.model.order;

import java.util.ArrayList;
import java.util.List;

public class compoundOrder extends Order {
    // Attributes for compound order.
    List<singleOrder> orderList = new ArrayList<>();

    //----------------------------------------------------------------


    public compoundOrder(int customerId, List<singleOrder> orderList) {
        this.customerId = customerId;
        this.orderList = orderList;
    }

    //----------------------------------------------------------------


    public List<singleOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<singleOrder> orderList) {
        this.orderList = orderList;
    }
}
