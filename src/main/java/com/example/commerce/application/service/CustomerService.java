package com.example.commerce.application.service;

import com.example.commerce.data.repository.CustomerRepository;
import com.example.commerce.domain.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer;

    public String addCustomer(Customer customerValue){
        Optional<Customer> findCustomer = customerRepository.findByName(customerValue.getName());

        if (findCustomer.isPresent()){
            throw new IllegalStateException("Customer already exists");
        }else{
            customer = new Customer();
            customer.setName(customerValue.getName());
            customer.setAddress(customerValue.getAddress());
            customer.setHandphone(customerValue.getHandphone());

            customerRepository.save(customer);
        }

        return "Customer "+customerValue.getName()+" success added";
    }

    public ResponseEntity<Customer> updateCustomer(Long idCustomer, Customer customerValue){
        customer = customerRepository.findById(idCustomer).orElseThrow(() -> new IllegalStateException("Customer not found"));

        customer.setName(customerValue.getName());
        customer.setAddress(customerValue.getAddress());
        customer.setHandphone(customerValue.getHandphone());

        final Customer updateCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updateCustomer);
    }

    public List<Customer> findAll(){
        return this.customerRepository.findAll();
    }
}
