package com.momo.orders_and_notifications_management.service.shipment;

import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.order.Order;

public interface Ship {
    void ship (Customer customer,Order order);
}
