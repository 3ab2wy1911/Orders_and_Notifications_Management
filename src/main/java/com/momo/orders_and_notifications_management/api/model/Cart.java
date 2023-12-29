package com.momo.orders_and_notifications_management.api.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    // Attributes
    private final List<Order> orderList;

    //----------------------------------------------------------------
    Cart(){
        orderList = new ArrayList<>();
    }

    //----------------------------------------------------------------

    public List<Order> getOrderList() {
        return orderList;
    }

}
