package com.momo.orders_and_notifications_management.api.model.order.print_order_details;

import com.momo.orders_and_notifications_management.api.model.order.Order;

public interface Print {
    String print(Order order);
}
