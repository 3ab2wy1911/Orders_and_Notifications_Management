package com.momo.orders_and_notifications_management.api.model.order.shipment;

import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.order.Order;

import java.util.List;

public class CompoundShipment implements Ship{
    @Override
    public String ship(Order compound) {
        if(compound.getPaymentStatus().equals("unpaid")){
            return "Can't ship an order without being paid";
        }
        List<Order> orders = compound.getOrderList();
        StringBuilder msg= new StringBuilder("Shipping Compound order !! \n");
        double shipmentFees = (double)50/ orders.size();

        for (Order order : orders) {
            Customer customer = order.getCustomer();
            customer.setBalance(customer.getBalance() - (shipmentFees));
            order.setShipmentStatus("Shipped");
            msg.append("The remaining balance after paying shipping fees is for customer : ").append(customer.getName()).append(" is ").append(customer.getBalance()).append(".\n");
        }
        compound.setShipmentStatus("Shipped");
        return msg.toString();
    }
}
