package com.example.commerce.controller;

import com.example.commerce.application.service.CustomerService;
import com.example.commerce.domain.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "customer")
    public String addCustomer(@RequestBody Customer customer){
        return this.customerService.addCustomer(customer);
    }

    @PutMapping(value = "customer/{idCustomer}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("idCustomer") Long idCustomer, @RequestBody Customer customer){
        return this.customerService.updateCustomer(idCustomer, customer);
    }

    @GetMapping(value = "customers")
    public List<Customer> findAllCustomer(){
        return this.customerService.findAll();
    }
}
