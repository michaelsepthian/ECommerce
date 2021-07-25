package com.example.commerce.application.service;

import com.example.commerce.data.dto.PaymentDto;
import com.example.commerce.data.repository.CartRepository;
import com.example.commerce.data.repository.PaymentRepository;
import com.example.commerce.data.repository.ProductRepository;
import com.example.commerce.domain.entity.Cart;
import com.example.commerce.domain.entity.Payment;
import com.example.commerce.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    private Payment payment;
    private Cart cart;
    private Product product;

    public String payment(PaymentDto paymentDto){
        cart = cartRepository.findById(paymentDto.getIdCart()).orElseThrow(() -> new IllegalStateException("Cart not found"));
        product = productRepository.findById(cart.getProduct().getId()).orElseThrow(() -> new IllegalStateException("Product not found"));

        int total = 0;

        if (cart.getQty() > product.getStock()){
            throw new IllegalStateException("Stock not enough");
        }else{

            LocalDateTime now = LocalDateTime.now();

            int sold = cart.getQty() + product.getSold();
            int stock = product.getStock() - cart.getQty();
            total = cart.getQty() * cart.getProduct().getPrice();

            //set stock for product
            product.setSold(sold);
            product.setStock(stock);

            //set status "paid" for cart
            cart.setStatus("paid");


            payment = new Payment();
            payment.setCart(cart);
            payment.setDate(now);
            payment.setMethod(paymentDto.getMethod());
            payment.setTotal(total);

            paymentRepository.save(payment);
        }


        return "Payment "+cart.getProduct().getName() + ", total: Rp."+total+" success";
    }

    public List<Payment> findAll(){
        return this.paymentRepository.findAll();
    }
}
