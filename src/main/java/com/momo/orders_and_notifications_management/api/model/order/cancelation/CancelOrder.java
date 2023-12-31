package com.momo.orders_and_notifications_management.api.model.order.cancelation;

import com.momo.orders_and_notifications_management.api.model.order.Order;

public interface CancelOrder {
     String cancel(Order order);
}
