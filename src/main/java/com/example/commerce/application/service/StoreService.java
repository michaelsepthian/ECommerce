package com.example.commerce.application.service;

import com.example.commerce.data.repository.StoreRepository;
import com.example.commerce.domain.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    private Store store;

    public String addStore(Store storeValue){
        store = new Store();

        store.setName(storeValue.getName());
        store.setAddress(storeValue.getAddress());
        storeRepository.save(store);

        return "Success add store "+storeValue.getName();
    }

    public ResponseEntity<Store> updateStore(Long idStore, String name, String address){
        store = storeRepository.findById(idStore).orElseThrow(() -> new IllegalStateException("Store not found"));

        store.setName(name);
        store.setAddress(address);
        final Store updateStore = storeRepository.save(store);

        return ResponseEntity.ok(updateStore);
    }

    @Transactional
    public String deleteStore(Long idStore){
        store = storeRepository.findById(idStore).orElseThrow(() -> new IllegalStateException("Store not found"));

        store.setStatus_delete(true);
        return "Store deleted";
    }

    public List<Store> findAll(){
        return this.storeRepository.findAll();
    }

    public List<Store> findAllByStatus(){
        return this.storeRepository.findAllByStatus_delete(false);
    }
}
