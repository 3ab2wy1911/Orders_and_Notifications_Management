package com.momo.orders_and_notifications_management.api.model.Channel;

import com.momo.orders_and_notifications_management.api.model.TemplateStrategy.Template;

public class Channel {
    protected String name;
    protected String productName;
    private String message;
    protected Template templateStrategy;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Template getTemplateStrategy() {
        return templateStrategy;
    }

    public void setMessage(String customerName, String productName){
        this.message = "Dear " + customerName + ", your booking of the item " + productName + " is confirmed\n";
    }
    public String getMessage(){
        return message;
    }
}
