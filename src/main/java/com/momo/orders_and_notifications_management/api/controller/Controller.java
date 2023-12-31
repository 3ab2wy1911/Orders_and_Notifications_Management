package com.momo.orders_and_notifications_management.api.controller;


import com.momo.orders_and_notifications_management.api.model.Product;
import com.momo.orders_and_notifications_management.api.model.order.CompoundOrder;
import com.momo.orders_and_notifications_management.api.model.order.Order;
import com.momo.orders_and_notifications_management.api.model.order.SingleOrder;
import com.momo.orders_and_notifications_management.service.CompoundOrderRequest;
import com.momo.orders_and_notifications_management.service.CustomerService;
import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.service.OrderService;
import com.momo.orders_and_notifications_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private final CustomerService customerService;
    private final ProductService productService;
    private final OrderService orderService;
    private Customer customer;

    //----------------------------------------------------------------

    @Autowired
    public Controller(CustomerService customerService, ProductService productService, OrderService orderService) {
        this.customerService = customerService;
        this.productService = productService;
        this.orderService = orderService;
    }

    //----------------------------------------------------------------

    @GetMapping("/customer")
    public String getCustomer(@RequestParam Integer id) {
        customer = customerService.getCustomer(id);
        if (customer == null) {
            return "Customer not found !!!";
        }
        return ("Welcome " + customer.getName() +
                "!\nYour current Balance: " + customer.getBalance()
                + ".\nYour current Address: " + customer.getAddress()
                + ".\nYour current e-mail: " + customer.getEmail()
                + ".\nYour current Phone Number : " + customer.getPhoneNumber()
                + ".");
    }

    //----------------------------------------------------------------
    // Cart, Orders and Products methods...
    @GetMapping("/viewProducts")
    public String viewProduct() {    // To view all the products...
        return productService.getProducts();
    }

    //-----------------

    @PostMapping("/addSingleOrder")
    public String addSingleOrder(@RequestParam Integer productId) {
        Product product = productService.getProduct(productId);
        if (product == null) {
            return "Product not found !!";
        }
        Order order = new SingleOrder(customer.getId(), product);
        customerService.addOrder(order, customer.getId());
        return "Order added successfully with id : " + order.getOrderId();
    }

    //-----------------
    @PostMapping("/addCompoundOrder")
    public String addCompoundOrder(@RequestBody CompoundOrderRequest requestBody) {
        List<SingleOrder> orders = new ArrayList<>();
        for (int i = 0; i < requestBody.getProductIds().size(); i++) {
            Product product = productService.getProduct(requestBody.getProductIds().get(i));
            if (product == null) {
                return "Product not found for id: " + requestBody.getProductIds().get(i);
            }
            Customer tmpCustomer = customerService.getCustomer(requestBody.getCustomerIds().get(i));
            if (tmpCustomer == null) {
                return "Customer not found for id: " + requestBody.getCustomerIds().get(i);
            }
            orders.add(new SingleOrder(requestBody.getCustomerIds().get(i), product));
        }
        Order order = new CompoundOrder(customer.getId(), orders);
        customerService.addOrder(order, customer.getId());

        return "Compound Order added successfully with id : " + order.getOrderId();
    }
    //-----------------

    @GetMapping("/printOrderDetails")
    public String getOrderDetails(@RequestParam Integer orderId) {
        if (customer == null) {
            return "Please Sign In First!!";
        }
        Order order = customerService.getOrder(customer.getId(), orderId);
        if (order == null) {
            return "Order not found";
        }
        return order.print();
    }

    //----------------------------------------------------------------
    @PostMapping(value = "/AddAccount")
    public String AddAccount(@RequestBody Customer customer) {
        String result = customerService.addCustomerAccount(customer);
        return result;
    }

    //----------------------------------------------------------------
    @GetMapping(value = "/getCustomerAccount/{id}")
    public String getCustomerAccount(@PathVariable int AccountId) {
        customer = customerService.getCustomerAccount(AccountId);
        if (customer == null) {
            return "Customer Account not found!!!";
        }
        return "Welcome " + customer.getName() +
                "!\nYour current Balance: " + customer.getBalance() +
                ".\nYour current e-mail: " + customer.getEmail() + ".";
    }
}