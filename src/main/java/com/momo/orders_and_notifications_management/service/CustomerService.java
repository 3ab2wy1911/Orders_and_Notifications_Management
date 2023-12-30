package com.momo.orders_and_notifications_management.service;

import com.momo.orders_and_notifications_management.api.model.Cart;
import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.order.Order;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {
    private final List<Customer> customerList;
    CustomerService(){
        customerList = new ArrayList<>();

        Customer customer1 = new Customer(1, "Mohamed Ahmed", "Faisel Giza", "3ab2wy1911@gmail.com", "01095454010", 1000);
        Customer customer2 = new Customer(2, "Omar Mohamed", "Faisel Giza", "city@gmail.com", "010", 10000);
        Customer customer3 = new Customer(3, "Ahmed Shabaan", "Helwan", "Sh3boo@gmail.com", "011", 200000);
        Customer customer4 = new Customer(4, "Mohamed Ryad", "3ayat", "nmrettelephonekkam@gmail.com", "012345678911", 10.99);

        customerList.addAll(Arrays.asList(customer1, customer2, customer3, customer4));
    }

    public Customer getCustomer(int id){
        for (Customer customer : customerList){
            if(customer.getId() == id){
                return customer;
            }
        }
        return null;
    }

    //----------------------------------------------------------------
    public void addOrder(Order order, int customerId){

        getCustomer(customerId).updateCart(order);
    }

    //
    public Order getOrder(int customerId, int orderId){ // for printing details of order...
        Cart cart = getCustomer(customerId).getCart();
        for (Order order : cart.getOrderList()){
            if (order.getOrderId() == orderId){
                return order;
            }
        }
        return null;
    }

}
