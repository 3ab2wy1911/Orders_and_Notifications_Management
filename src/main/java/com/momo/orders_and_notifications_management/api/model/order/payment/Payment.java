package com.momo.orders_and_notifications_management.api.model.order.payment;

import com.momo.orders_and_notifications_management.api.model.order.Order;

public interface Payment {
    String pay(Order order);
}
