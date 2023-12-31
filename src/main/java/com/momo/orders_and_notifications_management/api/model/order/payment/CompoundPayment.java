package com.momo.orders_and_notifications_management.api.model.order.payment;

import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.order.Order;

import java.util.ArrayList;
import java.util.List;

public class CompoundPayment implements Payment{

    @Override
    public String pay(Order compoundOrder) {
        if (compoundOrder.getPaymentStatus().equals("Paid")){
            return  "Order has been paid !!!";
        }
        List<Order> orders = compoundOrder.getOrderList();
        List<Double> balances = new ArrayList<>();
        for (Order order : orders){
            Customer customer = order.getCustomer();
            balances.add(customer.getBalance());
        }
        for (Order order : orders) {
            Customer customer = order.getCustomer();
            if(customer.getBalance() < order.getProduct().getPrice()){
                int i =0;
                for(Order o : orders){
                    Customer tmpCustomer = o.getCustomer();
                    tmpCustomer.setBalance(balances.get(i++));
                }
                return "Insufficient Balance to do the operation for Customer " + customer.getName()
                        +"\nPayment Failed !!!";
            }
            customer.setBalance(customer.getBalance() - order.getProduct().getPrice());
        }

        StringBuilder msg= new StringBuilder("Payment Success !! \n");
        for (Order order : orders) {
            Customer customer = order.getCustomer();
            order.setPaymentStatus("Paid");
            msg.append("The remaining balance for customer : ").append(customer.getName()).append(" is ").append(customer.getBalance()).append(".\n");
        }
        compoundOrder.setPaymentStatus("Paid");
        return msg.toString();
    }
}
