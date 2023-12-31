package com.momo.orders_and_notifications_management.api.model.order.shipment;

import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.order.Order;

import java.util.List;

public class CompundShapmint implements Ship{
    @Override
    public String ship(Order compound) {
        List<Order> orders = compound.getOrderList();
        StringBuilder msg= new StringBuilder("Shipping Compound order !! \n");
        double l =30/ orders.size();

        for (Order order : orders) {
            Customer customer = order.getCustomer();
            customer.setBalance(customer.getBalance() - (l));
            order.setPaymentStatus("Shipped");
            msg.append("The remaining balance after paying shipping fees is for customer : ").append(customer.getName()).append(" is ").append(customer.getBalance()).append(".\n");
        }
        return msg.toString();
    }
}
