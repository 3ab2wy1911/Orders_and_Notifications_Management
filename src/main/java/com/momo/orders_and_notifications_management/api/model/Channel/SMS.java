package com.momo.orders_and_notifications_management.api.model.Channel;

import com.momo.orders_and_notifications_management.api.model.TemplateStrategy.ShipmentTemplate;
import com.momo.orders_and_notifications_management.api.model.TemplateStrategy.Template;

public class SMS extends Channel{
    public void setStrategy(Template shipmentTemplate){
        this.templateStrategy = shipmentTemplate;
    }

}
