package com.momo.orders_and_notifications_management.api.controller;


import com.momo.orders_and_notifications_management.api.model.Product;
import com.momo.orders_and_notifications_management.api.model.order.CompoundOrder;
import com.momo.orders_and_notifications_management.api.model.order.Order;
import com.momo.orders_and_notifications_management.api.model.order.SingleOrder;
import com.momo.orders_and_notifications_management.service.CompoundOrderRequest;
import com.momo.orders_and_notifications_management.service.CustomerService;
import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.service.order.OrderService;
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

    //================================================================
    // Getting the customer and Adding New Customer...

    @GetMapping("/customer")
    public String getCustomer(@RequestParam Integer id) {   // Getting the customer and printing its info... "like sign in"
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

    @PostMapping(value = "/addCustomer")    // Adding a new customer...
    public String addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomerAccount(customer);
    }

    //----------------------------------------------------------------
    //================================================================
    // Controlling the Products , Adding Orders & Printing Status of each Order....
    @GetMapping("/viewProducts")    // View all the available products...
    public String viewProduct() {    // To view all the products...
        return productService.getProducts();
    }

    //----------------------------------------------------------------

    @PostMapping("/addSingleOrder") // Add a single order...
    public String addSingleOrder(@RequestParam Integer productId) {
        if (customer == null) {
            return "Please sign in first...";
        }
        Product product = productService.getProduct(productId);
        if (product == null) {
            return "Product not found !!";
        }
        Order order = new SingleOrder(customer, product);
        customerService.addOrder(order, customer.getId());
        return "Order added successfully with id : " + order.getOrderId();
    }

    //-----------------------------------------------
    @PostMapping("/addCompoundOrder")   // Add A compound Order...
    public String addCompoundOrder(@RequestBody CompoundOrderRequest requestBody) {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < requestBody.getProductIds().size(); i++) {
            Product product = productService.getProduct(requestBody.getProductIds().get(i));
            if (product == null) {
                return "Product not found for id: " + requestBody.getProductIds().get(i);
            }
            Customer tmpCustomer = customerService.getCustomer(requestBody.getCustomerIds().get(i));
            if (tmpCustomer == null) {
                return "Customer not found for id: " + requestBody.getCustomerIds().get(i);
            }
            orders.add(new SingleOrder(tmpCustomer, product));
        }
        Order order = new CompoundOrder(customer, orders);
        customerService.addOrder(order, customer.getId());

        return "Compound Order added successfully with id : " + order.getOrderId();
    }
    //----------------------------------------------------------------

    @GetMapping("/printOrderDetails")   // Print the order details...
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
    //================================================================
    // Order Payment & Shipment

    @GetMapping("/pay")   // Print the order details...
    public String payOrder(@RequestParam Integer orderId) {
        if (customer == null) {
            return "Please Sign In First!!";
        }
        Order order = customerService.getOrder(customer.getId(), orderId);
        if (order == null) {
            return "Order not found";
        }
        return order.pay();
    }

    //----------------------------------------------------------------

    @GetMapping("/shiporder")   // Print the order details...
    public String ShopOrder(@RequestParam Integer orderId) {
        if (customer == null) {
            return "Please Sign In First!!";
        }
        Order order = customerService.getOrder(customer.getId(), orderId);
        if (order == null) {
            return "Order not found";
        }
        return order.ship();
    }
    //----------------------------------------------------------------

    //================================================================
    // Notification System & Statistics....


}