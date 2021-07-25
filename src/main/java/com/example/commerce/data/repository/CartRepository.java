package com.example.commerce.data.repository;

import com.example.commerce.domain.entity.Cart;
import com.example.commerce.domain.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>, JpaSpecificationExecutor<Cart> {
    @Query("SELECT cart FROM Cart cart WHERE(cart.status = ?1)")
    List<Cart> findAllByStatusUnpaid(String status);

    @Query("SELECT cart FROM Cart cart WHERE(cart.status = ?1)")
    List<Cart> findAllByStatusPaid(String status);
}
