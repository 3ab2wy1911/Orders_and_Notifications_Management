package com.momo.orders_and_notifications_management.api.model;

import com.momo.orders_and_notifications_management.api.model.order.Order;

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

    //----------------------------------------------------------------

    public void update(Order order){
        int id;
        if(orderList.isEmpty()){
            id = 0;
        }
        else {
            id = orderList.get(orderList.size()-1).getOrderId();
        }
        order.setOrderId(id+1);
        orderList.add(order);
    }
    public void deletFromCart(Order order){
        int id;
        if(orderList.isEmpty()){
            id = 0;
        }
        else {
            id = orderList.get(orderList.size()-1).getOrderId();
        }
        order.setOrderId(id+1);
        orderList.remove(id);
    }

}
