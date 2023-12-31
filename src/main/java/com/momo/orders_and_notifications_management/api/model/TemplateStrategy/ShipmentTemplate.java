package com.momo.orders_and_notifications_management.api.model.TemplateStrategy;

public class ShipmentTemplate extends Template{

    @Override
    public String forumulateMessage(String name, String product) {
        return "Dear " + name + ", your booking of the item " + product + "is shipped\n";
    }
}
