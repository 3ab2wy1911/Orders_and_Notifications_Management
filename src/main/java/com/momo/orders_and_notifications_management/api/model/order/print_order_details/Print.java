package com.momo.orders_and_notifications_management.api.model.order.print_order_details;

import com.momo.orders_and_notifications_management.api.model.order.Order;
import com.momo.orders_and_notifications_management.service.ProductService;

public interface Print {
    ProductService productService = new ProductService();
    String print(Order order);
}
