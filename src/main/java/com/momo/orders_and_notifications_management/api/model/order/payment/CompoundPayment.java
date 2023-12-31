package com.momo.orders_and_notifications_management.api.model.order.payment;

import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.order.Order;

import java.util.List;

public class CompoundPayment implements Payment{

    @Override
    public String pay(Order compoundOrder) {
        List<Order> orders = compoundOrder.getOrderList();
        for (Order order : orders) {
            Customer customer = order.getCustomer();
            if(customer.getBalance() < order.getProduct().getPrice()){
                return "Insufficient Balance to do the operation for Customer " + customer.getName()
                        +"\nPayment Failed !!!";
            }
        }
        StringBuilder msg= new StringBuilder("Payment Success !! \n");
        for (Order order : orders) {
            Customer customer = order.getCustomer();
            customer.setBalance(customer.getBalance() - order.getProduct().getPrice());
            order.setPaymentStatus("Paid");
            msg.append("The remaining balance for customer : ").append(customer.getName()).append(" is ").append(customer.getBalance()).append(".\n");
        }
        return msg.toString();
    }
}
