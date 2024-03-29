package com.example.commerce.controller;

import com.example.commerce.application.service.ProductService;
import com.example.commerce.data.dto.ProductDto;
import com.example.commerce.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "product")
    public String addProduct(@RequestBody ProductDto productDto){
        return this.productService.addProduct(productDto);
    }

    @PutMapping(value = "product/{idProduct}")
    public ResponseEntity<Product> updateProductBrand(@PathVariable("idProduct") Long idProduct, @RequestBody ProductDto productDto){
        return this.productService.updateProductBrand(idProduct, productDto);
    }

    @PutMapping(value = "product/restock/{idProduct}")
    public ResponseEntity<Product> restock(@PathVariable("idProduct") Long idProduct, @RequestBody ProductDto productDto){
        return this.productService.updateStock(idProduct, productDto.getStock(), "add");
    }

    @PutMapping(value = "product/decrementStock/{idProduct}")
    public ResponseEntity<Product> decrementStock(@PathVariable("idProduct") Long idProduct, @RequestBody ProductDto productDto){
        return this.productService.updateStock(idProduct, productDto.getStock(), "reduce");
    }

    @GetMapping(value = "products")
    public List<Product> findAll(){
        return this.productService.findAll();
    }
}
