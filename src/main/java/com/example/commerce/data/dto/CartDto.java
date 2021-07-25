package com.example.commerce.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CartDto {
    @JsonProperty("product")
    private Long idProduct;
    @JsonProperty("customer")
    private Long idCustomer;
    @JsonProperty("qty")
    private int qty;
}
