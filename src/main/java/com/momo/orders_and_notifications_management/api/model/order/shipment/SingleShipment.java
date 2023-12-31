package com.momo.orders_and_notifications_management.api.model.order.shipment;

import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.order.Order;

public class SingleShipment implements Ship{
    @Override
    public String ship(Order single) {
        if(single.getPaymentStatus().equals("unpaid")){
            return "Can't ship an order without being paid";
        }
        Customer customer = single.getCustomer();
        customer.setBalance(customer.getBalance()-30);
        single.setShipmentStatus("Shipped");
        return "Your order is shipped and your balance after paying shipping fees is "+customer.getBalance();
    }
}
