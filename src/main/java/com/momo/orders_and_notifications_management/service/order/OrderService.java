package com.momo.orders_and_notifications_management.service.order;

import com.momo.orders_and_notifications_management.api.model.order.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
