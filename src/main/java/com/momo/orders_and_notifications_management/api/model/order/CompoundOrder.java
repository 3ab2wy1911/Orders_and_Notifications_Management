package com.momo.orders_and_notifications_management.api.model.order;

import java.util.ArrayList;
import java.util.List;

public class CompoundOrder extends Order {
    // Attributes for compound order.
    List<SingleOrder> orderList = new ArrayList<>();

    //----------------------------------------------------------------


    public CompoundOrder(int customerId, List<SingleOrder> orderList) {
        this.customerId = customerId;
        this.orderList = orderList;
    }

    //----------------------------------------------------------------


    public List<SingleOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<SingleOrder> orderList) {
        this.orderList = orderList;
    }
}
