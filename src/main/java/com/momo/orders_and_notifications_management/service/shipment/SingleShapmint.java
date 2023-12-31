package com.momo.orders_and_notifications_management.service.shipment;

import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.order.Order;

public class SingleShapmint implements Ship{

    @Override
    public void ship(Customer customer,Order order) {
        customer.setBalance(customer.getBalance()-30);
//        for (Customer customer : customerList){
//            if(customer.getId() == order.getCustomerId()){
//
//            }
//        }

    }
}
