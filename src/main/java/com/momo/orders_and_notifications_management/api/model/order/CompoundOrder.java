package com.momo.orders_and_notifications_management.api.model.order;

import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.order.payment.CompoundPayment;
import com.momo.orders_and_notifications_management.api.model.order.print_order_details.PrintCompoundOrder;

import java.util.List;

public class CompoundOrder extends Order {

    public CompoundOrder(Customer customer, List<Order> orderList) {
        super(customer);
        this.orderList = orderList;
        this.type = "Compound Order";
        this.product = null;
        this.print = new PrintCompoundOrder();
        this.payment = new CompoundPayment();
    }

    //----------------------------------------------------------------


    public List<Order> getOrderList() {
        return orderList;
    }

}
