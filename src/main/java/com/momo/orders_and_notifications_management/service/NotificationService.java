package com.momo.orders_and_notifications_management.service;

import com.momo.orders_and_notifications_management.api.model.Channel.Channel;
import com.momo.orders_and_notifications_management.api.model.ChannelFactory.ChannelAndLangFac;
import com.momo.orders_and_notifications_management.api.model.NotificationRequest;

import java.util.Queue;

public class NotificationService {
    private ChannelAndLangFac channelAndLangFac;
    private String productName;
    private Queue<Channel> notificationQueue;

    public String createChannel(NotificationRequest notificationRequest){
        Channel channel = channelAndLangFac.createChannel(notificationRequest.getTypeOfChannel());

        channel.setName(notificationRequest.getCustomerName());
        channel.setProductName(notificationRequest.getProductName());
        channel.setMessage(notificationRequest.getCustomerName(), notificationRequest.getProductName());

        notificationQueue.add(channel);
        return channel.getMessage();
    }
}
