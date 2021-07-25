package com.example.commerce.application.service;

import com.example.commerce.data.dto.ProductDto;
import com.example.commerce.data.repository.ProductRepository;
import com.example.commerce.data.repository.StoreRepository;
import com.example.commerce.domain.entity.Product;
import com.example.commerce.domain.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StoreRepository storeRepository;

    private Product product;
    private Store store;

    public String addProduct(ProductDto productDto){
        store = storeRepository.findById(productDto.getIdStore()).orElseThrow(() -> new IllegalStateException("Store not found"));
        product = new Product();

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStore(store);

        productRepository.save(product);

        return "Product "+productDto.getName()+" added";
    }

    public ResponseEntity<Product> updateProductBrand(Long idProduct, ProductDto productDto){
        product = productRepository.findById(idProduct).orElseThrow(() -> new IllegalStateException("Product not found"));
        store = storeRepository.findById(productDto.getIdStore()).orElseThrow(() -> new IllegalStateException("Store not found"));

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStore(store);

        final Product updateProductBrand = productRepository.save(product);
        return ResponseEntity.ok(updateProductBrand);
    }

    public ResponseEntity<Product> updateStock(Long idProduct, int stock, String action){
        product = productRepository.findById(idProduct).orElseThrow(() -> new IllegalStateException("Product not found"));
        int currentStock = 0;

        if (action.equals("add")){
            currentStock = product.getStock() + stock;
        }else{
            currentStock = product.getStock() - stock;
        }

        product.setStock(currentStock);

        final Product updateStock = productRepository.save(product);

        return ResponseEntity.ok(updateStock);
    }

    public List<Product> findAll(){
        return this.productRepository.findAll();
    }
}
