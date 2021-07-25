package com.example.commerce.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("store")
    private Long idStore;
    @JsonProperty("price")
    private int price;
    @JsonProperty("stock")
    private int stock;
}
