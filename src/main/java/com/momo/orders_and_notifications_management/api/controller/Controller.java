package com.momo.orders_and_notifications_management.api.controller;


import com.momo.orders_and_notifications_management.api.model.Product;
import com.momo.orders_and_notifications_management.api.model.order.Order;
import com.momo.orders_and_notifications_management.api.model.order.SingleOrder;
import com.momo.orders_and_notifications_management.service.CustomerService;
import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final CustomerService customerService;
    private final ProductService productService;
    private Customer customer;

    //----------------------------------------------------------------

    @Autowired
    public Controller(CustomerService customerService, ProductService productService) {
        this.customerService = customerService;
        this.productService = productService;
    }

    //----------------------------------------------------------------

    @GetMapping("/customer")
    public String getCustomer(@RequestParam Integer id){
        customer =  customerService.getCustomer(id);
        if(customer == null){
            return "Customer not found !!!";
        }
        return ("Welcome " + customer.getName() +
                "!\nYour current Balance: " + customer.getBalance()
                + ".\nYour current Address: "+ customer.getAddress()
                + ".\nYour current e-mail: "+ customer.getEmail()
                + ".\nYour current Phone Number : "+ customer.getPhoneNumber()
        + ".");
    }

    //----------------------------------------------------------------
    // Cart, Orders and Products methods...
    @GetMapping("/viewProducts")
    public String viewProduct(){    // To view all the products...
        return productService.getProducts();
    }

    //-----------------

    @PostMapping("/addOrder")
    public String addOrder(@RequestParam Integer productId){
        Product product = productService.getProduct(productId);
        if(product == null){
            return "Product not found !!";
        }
        Order order = new SingleOrder(customer.getId(),product);
        customerService.addOrder(order, customer.getId());
        return "Order added successfully with id : "+ order.getOrderId();
    }

    //-----------------

    @GetMapping("/printOrderDetails")
    public String getOrderDetails(@RequestParam Integer orderId){
        if (customer == null){
            return "Please Sign In First!!";
        }
        Order order = customerService.getOrder(customer.getId(), orderId);
        if(order == null){
            return "Order not found";
        }
        return "Order details\n Product Name : " + productService.getProduct(orderId).getName()+".\nOrder Type : " + order.getType()+".\nPrice : " +
                productService.getProduct(orderId).getPrice()+".\n";
    }

    //-----------------


}
