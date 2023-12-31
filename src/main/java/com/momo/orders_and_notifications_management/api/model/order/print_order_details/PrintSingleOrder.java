package com.momo.orders_and_notifications_management.api.model.order.print_order_details;

import com.momo.orders_and_notifications_management.api.model.order.Order;

public class PrintSingleOrder implements Print {

    @Override
    public String print(Order order) {
        return "Order details\n" +
                "Product Name : " +order.getProduct().getName()  +
                "\n.Customer Name : " + order.getCustomer().getName() +
                ".\nOrder Type : " + order.getType() +
                ".\nOrder Fees : " + order.getProduct().getPrice() +
                ".\nOrder Status : " + order.getPaymentStatus() + " " + order.getShipmentStatus() +
              ".\n";
    }
}
