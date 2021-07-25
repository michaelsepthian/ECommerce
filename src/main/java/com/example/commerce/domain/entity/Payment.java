package com.example.commerce.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "payments")
public class Payment {
    @Id
    @SequenceGenerator(
            name = "payment_sequence",
            sequenceName = "payments_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payments_id_seq"
    )
    private long id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Cart cart;
    @Column(columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime date;
    private String method;
    private int total;
}
