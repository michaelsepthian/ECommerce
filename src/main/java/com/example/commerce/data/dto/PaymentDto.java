package com.example.commerce.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PaymentDto {
    @JsonProperty("cart")
    private Long idCart;
    @JsonProperty("method")
    private String method;
}
