package com.momo.orders_and_notifications_management.api.model.ChannelFactory;

import com.momo.orders_and_notifications_management.api.model.Channel.Channel;
import com.momo.orders_and_notifications_management.api.model.Channel.Email;
import com.momo.orders_and_notifications_management.api.model.Channel.SMS;
import com.momo.orders_and_notifications_management.api.model.TemplateStrategy.ShipmentTemplate;

public class ChannelFactory extends ChannelAndLangFac{

    @Override
    public Channel createChannel(String type) {
        if (type.equals("SMS")){
            SMS sms = new SMS();
            sms.setStrategy(new ShipmentTemplate());
            return sms;
        }
        else {
            Email email = new Email();
            email.setStrategy(new ShipmentTemplate());
            return email;
        }
    }
}
