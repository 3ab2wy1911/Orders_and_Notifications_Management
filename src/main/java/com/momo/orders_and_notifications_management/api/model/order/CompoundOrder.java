package com.momo.orders_and_notifications_management.api.model.order;

import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.order.print_order_details.PrintCompoundOrder;

import java.util.ArrayList;
import java.util.List;

public class CompoundOrder extends Order {
    // Attributes for compound order.

    //----------------------------------------------------------------


    public CompoundOrder(Customer customer, List<Order> orderList) {
        super(customer);
        this.orderList = orderList;
        this.type = "Compound Order";
        this.product = null;
        this.print = new PrintCompoundOrder();
    }

    //----------------------------------------------------------------


    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
