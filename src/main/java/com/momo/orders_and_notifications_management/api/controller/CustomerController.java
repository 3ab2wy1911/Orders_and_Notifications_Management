package com.momo.orders_and_notifications_management.api.controller;


import com.momo.orders_and_notifications_management.service.CustomerService;
import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerService customerService;
    private final ProductService productService;
    private Customer customer;

    //----------------------------------------------------------------

    @Autowired
    public CustomerController(CustomerService customerService, ProductService productService) {
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

    @GetMapping("/viewProducts")
    public String viewProduct(){
        return productService.getProducts();
    }

}
