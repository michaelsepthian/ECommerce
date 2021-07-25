package com.example.commerce.controller;

import com.example.commerce.application.service.PaymentService;
import com.example.commerce.data.dto.PaymentDto;
import com.example.commerce.domain.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "payment")
    public String payment(@RequestBody PaymentDto paymentDto){
        return this.paymentService.payment(paymentDto);
    }

    @GetMapping(value = "findAllPayment")
    public List<Payment> findAll(){
        return this.paymentService.findAll();
    }
}
