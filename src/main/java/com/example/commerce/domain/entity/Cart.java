package com.example.commerce.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "carts")
public class Cart {
    @Id
    @SequenceGenerator(
            name = "cart_sequence",
            sequenceName = "carts_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "carts_id_seq"
    )
    private long id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Product product;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Customer customer;
    private int qty;
    private String status;
}
