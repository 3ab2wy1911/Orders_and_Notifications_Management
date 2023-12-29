package com.momo.orders_and_notifications_management.api.controller;


import com.momo.orders_and_notifications_management.api.model.Customer;
import com.momo.orders_and_notifications_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/customer")
    public Customer getCustomer(@RequestParam Integer id){
        return customerService.getCustomer(id);
    }
}
