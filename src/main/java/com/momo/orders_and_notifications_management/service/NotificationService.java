package com.momo.orders_and_notifications_management.service;

import com.momo.orders_and_notifications_management.api.model.Channel.Channel;
import com.momo.orders_and_notifications_management.api.model.ChannelFactory.ChannelAndLangFac;
import com.momo.orders_and_notifications_management.api.model.ChannelFactory.ChannelFactory;
import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.NotificationRequest;
import com.momo.orders_and_notifications_management.api.model.order.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class NotificationService {
    private final ChannelAndLangFac channelAndLangFac = new ChannelFactory();
    private final List<Channel> NotificationQueue = new ArrayList<>();

    public String createChannel(Customer customer, Order order, NotificationRequest notificationRequest){

        Channel channel = channelAndLangFac.channelCreator(notificationRequest.getTypeOfChannel());
        channel.setName(customer.getName());
        channel.setMessage(customer.getName(), order);


        NotificationQueue.add(channel);
        return channel.getMessage();
    }
}
