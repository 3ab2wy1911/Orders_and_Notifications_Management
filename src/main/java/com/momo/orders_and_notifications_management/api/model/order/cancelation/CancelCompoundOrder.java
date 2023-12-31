package com.momo.orders_and_notifications_management.api.model.order.cancelation;

import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.order.Order;

import java.util.List;

public class CancelCompoundOrder implements CancelOrder{
    @Override
    public String cancel(Order compoundOrder) {
        List<Order> orders = compoundOrder.getOrderList();
        StringBuilder msg = new StringBuilder("Cancelling order...\n");
        int size = orders.size();
        for (Order order : orders) {
            Customer customer = order.getCustomer();
            if(order.getPaymentStatus().equals("Paid")){
                customer.setBalance(customer.getBalance() + order.getProduct().getPrice());
                msg.append("Order Fees have been returned to the balance for Customer : ").append(customer.getName()).append(" successfully... Current Balance : ").append(customer.getBalance()).append("\n");
            }
            if (order.getShipmentStatus().equals("Shipped")){
                customer.setBalance(customer.getBalance() +(double)50/size);
                msg.append("Shipment Fees have been returned to the balance for Customer : ").append(customer.getName()).append(" successfully... Current Balance : ").append(customer.getBalance()).append("\n");
            }
        }
        compoundOrder.getCustomer().removeOrder(compoundOrder);
        msg.append("Order with id ").append(compoundOrder.getOrderId()).append(" Removed Successfully for Customer : ").append(compoundOrder.getCustomer().getName());
        return msg.toString();
    }
}
