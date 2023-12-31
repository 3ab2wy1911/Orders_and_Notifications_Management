package com.momo.orders_and_notifications_management.api.model.order;

import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.Product;
import com.momo.orders_and_notifications_management.api.model.order.cancelation.CancelOrder;
import com.momo.orders_and_notifications_management.api.model.order.payment.Payment;
import com.momo.orders_and_notifications_management.api.model.order.print_order_details.Print;
import com.momo.orders_and_notifications_management.api.model.order.shipment.Ship;

import java.util.ArrayList;
import java.util.List;

public abstract class Order {
    // common attributes
    Customer customer;
    int orderId;
    String type;    // Single , Compound...
    Product product;
    List<Order> orderList = new ArrayList<>();
    String paymentStatus; //  Default -> "unpaid".
    String shipmentStatus; // Default -> "still not shipped..."
    Print print;
    Payment payment;
    Ship ship;
    CancelOrder cancelOrder;

    //----------------------------------------------------------------
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    //----------------------------------------------------------------
    public Order(Customer customer){
        this.customer = customer;
        this.orderId = -1;
        this.paymentStatus = "unpaid";
        this.shipmentStatus = "not shipped";
    }

    public Order() {
        this.customer = null;
        this.orderId = -1;
        this.paymentStatus = "unpaid";
        this.shipmentStatus = "not shipped";
    }
    //----------------------------------------------------------------

    public String getType() {
        return type;
    }

    public String getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }


    //----------------------------------------------------------------
    public Customer getCustomer() {
        return customer;
    }

    //----------------------------------------------------------------
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    //----------------------------------------------------------------
    public String print(){
        return print.print(this);
    }
    //-----------------------------------------------------------------
    public String pay(){
        return payment.pay(this);
    }
    //-----------------------------------------------------------------
    public String ship(){
        return ship.ship(this);
    }
    //----------------------------------------------------------------
    public String cancel(){
        return cancelOrder.cancel(this);
    }

}
