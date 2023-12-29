package com.moma.Orders_and_Notifications_Management.api.controller;


import com.moma.Orders_and_Notifications_Management.api.model.Customer;
import com.moma.Orders_and_Notifications_Management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/customer")
    public Customer getCustomer(@RequestParam Integer id){
        return customerService.getCustomer(id);
    }
}
