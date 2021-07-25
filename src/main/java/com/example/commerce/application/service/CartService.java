package com.example.commerce.application.service;

import com.example.commerce.data.dto.CartDto;
import com.example.commerce.data.repository.CartRepository;
import com.example.commerce.data.repository.CustomerRepository;
import com.example.commerce.data.repository.ProductRepository;
import com.example.commerce.domain.entity.Cart;
import com.example.commerce.domain.entity.Customer;
import com.example.commerce.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;

    private Cart cart;
    private Product product;
    private Customer customer;

    public String addCart(CartDto cartDto){
        customer = customerRepository.findById(cartDto.getIdCustomer()).orElseThrow(() -> new IllegalStateException("Customer not found"));
        product = productRepository.findById(cartDto.getIdProduct()).orElseThrow(() -> new IllegalStateException("Product not found"));
        String message = "";

        if (product.getStock() < cartDto.getQty()){
            throw new IllegalStateException("Stock not enough");
        }else{
            cart = new Cart();
            cart.setCustomer(customer);
            cart.setProduct(product);
            cart.setQty(cartDto.getQty());
            cart.setStatus("unpaid");
            cartRepository.save(cart);

            message = product.getName() + " added to cart";
        }

        return message;
    }

    public ResponseEntity<Cart> updateCart(Long idCart, CartDto cartDto){
        cart = cartRepository.findById(idCart).orElseThrow(() -> new IllegalStateException(("Cart not found")));
        product = productRepository.findById(cartDto.getIdProduct()).orElseThrow(() -> new IllegalStateException("Product not found"));
        final Cart updateCart;

        if (product.getStock() < cartDto.getQty()){
            throw new IllegalStateException("Stock not enough");
        }else{
            cart.setProduct(product);
            cart.setQty(cartDto.getQty());

            updateCart = cartRepository.save(cart);
        }


        return ResponseEntity.ok(updateCart);
    }

    public String deleteCart(Long idCart){
        cart = cartRepository.findById(idCart).orElseThrow(() -> new IllegalStateException("Cart not found"));

        cartRepository.deleteById(idCart);

        return "Cart deleted";
    }

    public List<Cart> findAll(){
        return this.cartRepository.findAll();
    }

    public List<Cart> findAllByStatusUnpaid(){
        return this.cartRepository.findAllByStatusUnpaid("unpaid");
    }

    public List<Cart> findAllByStatusPaid(){
        return this.cartRepository.findAllByStatusPaid("paid");
    }
}
