package com.momo.orders_and_notifications_management.api.model.ChannelFactory;

import com.momo.orders_and_notifications_management.api.model.Channel.Channel;

public abstract class ChannelAndLangFac {

    public abstract Channel createChannel(String type);
}
