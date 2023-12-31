package com.momo.orders_and_notifications_management.api.model.order.shipment;

import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.order.Order;

public interface Ship {
    String ship (Order order);
}
