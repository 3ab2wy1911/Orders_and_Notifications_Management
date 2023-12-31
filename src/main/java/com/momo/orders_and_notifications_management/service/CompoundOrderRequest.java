package com.momo.orders_and_notifications_management.service;

import java.util.ArrayList;
import java.util.List;

public class CompoundOrderRequest {
    private final List<Integer> productIds = new ArrayList<>();     // Product Id...
    private final List<Integer> customerIds = new ArrayList<>(); // Customer Id...

    public List<Integer> getProductIds() {
        return productIds;
    }

    public List<Integer> getCustomerIds() {
        return customerIds;
    }

}
