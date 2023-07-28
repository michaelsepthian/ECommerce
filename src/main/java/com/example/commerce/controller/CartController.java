package com.example.commerce.controller;

import com.example.commerce.application.service.CartService;
import com.example.commerce.data.dto.CartDto;
import com.example.commerce.domain.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping(value = "cart")
    public String addCart(@RequestBody CartDto cartDto){
        return this.cartService.addCart(cartDto);
    }

    @PutMapping(value = "cart/{idCart}")
    public ResponseEntity<Cart> updateCart(@PathVariable("idCart") Long idCart, @RequestBody CartDto cartDto){
        return this.cartService.updateCart(idCart, cartDto);
    }

    @DeleteMapping(value = "cart/{idCart}")
    public String deleteCart(@PathVariable("idCart") Long idCart){
        return this.cartService.deleteCart(idCart);
    }

    @GetMapping(value = "carts")
    public List<Cart> findAll(){
        return this.cartService.findAll();
    }

    @GetMapping(value = "findAllCartByStatusUnpaid")
    public List<Cart> findAllUnpaid(){
        return this.cartService.findAllByStatusUnpaid();
    }

    @GetMapping(value = "findAllCartByStatusPaid")
    public List<Cart> findAllPaid(){
        return this.cartService.findAllByStatusPaid();
    }
}
