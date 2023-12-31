package com.momo.orders_and_notifications_management.api.model.order;

import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.Product;
import com.momo.orders_and_notifications_management.api.model.order.cancelation.CancelSingleOrder;
import com.momo.orders_and_notifications_management.api.model.order.payment.SinglePayment;
import com.momo.orders_and_notifications_management.api.model.order.print_order_details.PrintSingleOrder;
import com.momo.orders_and_notifications_management.api.model.order.shipment.SingleShipment;

public class SingleOrder extends Order{

    //----------------------------------------------------------------
    public SingleOrder(Customer customer, Product product){
        super(customer);
        this.product = product;
        this.type = "Single Order";
        this.print = new PrintSingleOrder();
        this.payment = new SinglePayment();
        this.ship = new SingleShipment();
        this.cancelOrder = new CancelSingleOrder();
    }
    //----------------------------------------------------------------


}
