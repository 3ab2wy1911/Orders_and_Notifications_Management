package com.momo.orders_and_notifications_management.service;

import ch.qos.logback.core.joran.sanity.Pair;

import java.util.List;

public class CompoundOrderRequest {
    private List<Integer> productIds;     // Product Id...
    private List<Integer> customerIds; // Customer Id...

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }

    public List<Integer> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(List<Integer> customerIds) {
        this.customerIds = customerIds;
    }
}
