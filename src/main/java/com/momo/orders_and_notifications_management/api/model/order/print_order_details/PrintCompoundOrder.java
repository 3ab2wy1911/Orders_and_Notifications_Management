package com.momo.orders_and_notifications_management.api.model.order.print_order_details;

import com.momo.orders_and_notifications_management.api.model.order.Order;

public class PrintCompoundOrder implements Print{
    @Override
    public String print(Order order) {
        StringBuilder result = new StringBuilder("Order Details :\nOrder Id : " + order.getOrderId() + "\nOrder Type : " + order.getType() + "\nCustomer Name : " + order.getCustomer().getName() + ".\n");
        int cnt = 1;
        for (Order singleOrder : order.getOrderList()) {
            result.append("\nOrder : ").append(cnt++).append
                    (".\nProduct Name : ").append
                    (singleOrder.getProduct().getName()).append
                    ("\nReceiver Name : ").append
                    (singleOrder.getCustomer().getName()).append
                    (".\nOrder Fees : ").append
                    (singleOrder.getProduct().getPrice()).append
                    (".\nOrder Status : ").append
                    (order.getPaymentStatus()).append
                    (" ").append
                    (singleOrder.getShipmentStatus()).append
                    (".\n");
        }
        return result.toString();
    }
}
