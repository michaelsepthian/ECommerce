package com.example.commerce.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "products_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "products_id_seq"
    )
    private long id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Store store;
    private String name;
    @Column(columnDefinition = "integer default 0")
    private int stock;
    @Column(columnDefinition = "integer default 0")
    private int sold;
    private int price;
}
