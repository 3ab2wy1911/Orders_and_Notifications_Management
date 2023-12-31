package com.momo.orders_and_notifications_management.api.model.Channel;

import com.momo.orders_and_notifications_management.api.model.TemplateStrategy.ShipmentTemplate;

public class Email extends Channel{
    public void setStrategy(ShipmentTemplate shipmentTemplate){
        this.templateStrategy = shipmentTemplate;
    }

}
