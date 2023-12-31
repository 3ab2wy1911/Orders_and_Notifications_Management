package com.momo.orders_and_notifications_management.api.model.ChannelFactory;

import com.momo.orders_and_notifications_management.api.model.Channel.Channel;
import com.momo.orders_and_notifications_management.api.model.Channel.Email;
import com.momo.orders_and_notifications_management.api.model.Channel.SMS;
import com.momo.orders_and_notifications_management.api.model.TemplateStrategy.ShipmentTemplate;

public class ChannelFactory extends ChannelAndLangFac{

    @Override
    public Channel createChannel(String type) {
        if (type == "SMS"){
            Channel sms = new SMS();
            ((SMS) sms).setStrategy(new ShipmentTemplate());
            return sms;
        }
        else {
            Channel email = new Email();
            ((Email) email).setStrategy(new ShipmentTemplate());
            return email;
        }
    }
}
