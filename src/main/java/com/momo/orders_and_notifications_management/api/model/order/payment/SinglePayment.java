package com.momo.orders_and_notifications_management.api.model.order.payment;

import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.order.Order;

public class SinglePayment implements Payment{

    @Override
    public String pay(Order order) {
        Customer customer = order.getCustomer();
        if(customer.getBalance() < order.getProduct().getPrice()){
            return "Insufficient Balance to do the operation !!! Payment Failed !!!";
        }
        customer.setBalance(customer.getBalance() - order.getProduct().getPrice());
        order.setPaymentStatus("Paid");
        return "Payment Success !! The remaining balance for customer : "+ customer.getName() + " is " + customer.getBalance();
    }
}
