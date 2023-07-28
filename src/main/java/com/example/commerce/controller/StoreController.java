package com.example.commerce.controller;

import com.example.commerce.application.service.StoreService;
import com.example.commerce.data.dto.EditStoreDto;
import com.example.commerce.domain.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping(value = "store")
    public String addStore(@RequestBody Store store){
        return this.storeService.addStore(store);
    }

    @PutMapping(value = "store/{idStore}")
    public ResponseEntity<Store> updateStore(@PathVariable("idStore") Long idStore, @RequestBody EditStoreDto editStoreDto){
        return this.storeService.updateStore(idStore, editStoreDto.getName(), editStoreDto.getAddress());
    }

    @DeleteMapping(value = "store/{idStore}")
    public String deleteStore(@PathVariable("idStore") Long idStore){
        return this.storeService.deleteStore(idStore);
    }

    @GetMapping(value = "stores")
    public List<Store> findAll(){
        return this.storeService.findAll();
    }

    @GetMapping(value = "findAllStoreByStatus")
    public List<Store> findAllByStatus(){
        return this.storeService.findAllByStatus();
    }
}
