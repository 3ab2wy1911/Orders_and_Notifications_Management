package com.momo.orders_and_notifications_management.api.model.Channel;

import com.momo.orders_and_notifications_management.api.model.TemplateStrategy.Template;
import com.momo.orders_and_notifications_management.api.model.order.Order;

public class Channel {
    protected String name;
    private String message;
    protected Template templateStrategy;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setMessage(String customerName, Order order){
        if (order.getType().equals("Single Order")){
            this.message = "Dear " + customerName + ", your booking of the item " + order.getProduct().getName() + " is confirmed\n";
        }
        else{
            StringBuilder msg = new StringBuilder();
            for (Order singleOrder : order.getOrderList()) {
                msg.append(singleOrder.getProduct().getName()).append(" for customer : ").append(singleOrder.getCustomer().getName()).append("\n");
            }
            this.message = "Dear " + customerName + ", your booking of the items : \n"+msg;
        }
    }
    public String getMessage(){
        return message;
    }
}
