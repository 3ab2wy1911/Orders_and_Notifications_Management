package com.momo.orders_and_notifications_management.service;

import com.momo.orders_and_notifications_management.api.model.Cart;
import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.api.model.order.Order;
import com.momo.orders_and_notifications_management.service.shipment.Ship;
import com.momo.orders_and_notifications_management.service.shipment.SingleShapmint;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {
    private final List<Customer> customerList;

    private final List<Customer> customerAccountsList;

    CustomerService(){
        customerList = new ArrayList<>();

        Customer customer1 = new Customer(1, "Mohamed Ahmed", "Faisel Giza", "3ab2wy1911@gmail.com", "01095454010", 1000);
        Customer customer2 = new Customer(2, "Omar Mohamed", "Faisel Giza", "city@gmail.com", "010", 10000);
        Customer customer3 = new Customer(3, "Ahmed Shabaan", "Helwan", "Sh3boo@gmail.com", "011", 200000);
        Customer customer4 = new Customer(4, "Mohamed Ryad", "3ayat", "nmrettelephonekkam@gmail.com", "012345678911", 10.99);

        customerList.addAll(Arrays.asList(customer1, customer2, customer3, customer4));


        customerAccountsList = new ArrayList<>();
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
    public String shiporder(int customerID,int orderID ) {
        Cart cart = getCustomer(customerID).getCart();
        for (Order order : cart.getOrderList()) {
            if (order.getOrderId() == orderID) {
                if (order.getType().equals("Single Order")) {
//                    getCustomer(order.getCustomerId()).setBalance(this.getCustomer(orderID).getBalance() - 30);
//                    cart.deletFromCart(order);
//                    return " your order is shipped successfully " +
//                            "and your current balance after paying shipping fees is " + getCustomer(order.getCustomerId()).getBalance();
                    Ship sh = new SingleShapmint();
                    sh.ship(this.getCustomer(customerID),order);
                    double newBalance = getCustomer(order.getCustomerId()).getBalance();
                    cart.deletFromCart(order);
                    return " your order is shipped successfully " +
                            "and your current balance after paying shipping fees is " + newBalance;

                }
            }
        }
        return "No order with this id ";

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

    //----------------------------------------------------------------


//    add this account to CustomerAccountList
    public String addCustomerAccount(Customer customer){
            // Check if a customer with the given ID already exists
            for (Customer existingCustomer : customerAccountsList) {
                if (existingCustomer.getId() == customer.getId()) {
                    return "Customer with ID " + customer.getId() + " already exists.";
                }
            }
            // If the customer ID is unique, add the customer to the list
        customerAccountsList.add(customer);
            return "Customer Account Added Successfully";
        }

    //----------------------------------------------------------------

//    function to search for this customer account ,return this customer to print it
    public Customer getCustomerAccount(int AccountId){
        for (Customer c : customerAccountsList){
            if(c.getId() == AccountId){
                return c;
            }
        }
        return null;
    }


}
