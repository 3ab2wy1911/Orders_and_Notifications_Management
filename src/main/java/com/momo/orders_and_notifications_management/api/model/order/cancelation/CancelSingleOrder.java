package com.momo.orders_and_notifications_management.api.model.order.cancelation;

import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.order.Order;

public class CancelSingleOrder implements CancelOrder{

    @Override
    public String cancel(Order order) {
            String msg = "Cancelling order...\n";
            Customer customer = order.getCustomer();
            if(order.getPaymentStatus().equals("Paid")){
                customer.setBalance(customer.getBalance() + order.getProduct().getPrice());
                msg += "Order Fees have been returned to the balance successfully... Your current Balance : "+customer.getBalance()+"\n";
            }
            if (order.getShipmentStatus().equals("Shipped")){
                customer.setBalance(customer.getBalance() + 30);
                msg += "Shipment Fees have been returned to the balance successfully... Your current Balance : "+customer.getBalance()+"\n";
            }
            customer.removeOrder(order);
            msg += "Order with id " + order.getOrderId()+" Removed Successfully";
            return msg;
    }
}
