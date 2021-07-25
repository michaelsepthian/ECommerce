package com.example.commerce.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "stores")
public class Store {
    @Id
    @SequenceGenerator(
            name = "store_sequence",
            sequenceName = "stores_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stores_id_seq"
    )
    private long id;
    private String name;
    private String address;
    @Column(columnDefinition = "BOOLEAN DEFAULT false", nullable = false)
    private boolean status_delete;
}
