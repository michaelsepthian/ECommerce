package com.example.commerce.data.repository;

import com.example.commerce.domain.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>, JpaSpecificationExecutor<Store> {
    @Query("SELECT store FROM Store store WHERE(store.status_delete = ?1)")
    List<Store> findAllByStatus_delete(boolean status_delete);
}