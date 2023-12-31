package com.momo.orders_and_notifications_management.service;

import com.momo.orders_and_notifications_management.api.model.Channel.Channel;
import com.momo.orders_and_notifications_management.api.model.Channel.SMS;
import com.momo.orders_and_notifications_management.api.model.ChannelFactory.ChannelAndLangFac;
import com.momo.orders_and_notifications_management.api.model.ChannelFactory.ChannelFactory;
import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.NotificationRequest;
import com.momo.orders_and_notifications_management.api.model.order.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
@Service
public class NotificationService {
    private ChannelAndLangFac channelAndLangFac = new ChannelFactory();
    private String productName;
    private List<Channel> NotificationQueue = new ArrayList<>();

    public String createChannel(NotificationRequest notificationRequest, Customer customer){
        if (customer == null){
            return "Please sign in first...";
        }
        Channel channel = channelAndLangFac.channelCreator(notificationRequest.getTypeOfChannel());
        String productName = "";
        boolean found = false;
        for (Order order : customer.getCart().getOrderList()){
            if (order.getOrderId() == notificationRequest.getOrderId()){
                if (order.getProduct().getName() == null){
                    channel.setName(customer.getName());
                    channel.setMessage(customer.getName(), "");
                    break;
                }
                else {
                    productName = order.getProduct().getName();
                    channel.setName(customer.getName());
                    channel.setMessage(customer.getName(), productName);
                    break;
                }
            }
        }
        if (productName.equals("")){
            return "Dear " + customer.getName() + " no order found at this id " + notificationRequest.getOrderId();
        }
        NotificationQueue.add(channel);
        return channel.getMessage();
    }
}
