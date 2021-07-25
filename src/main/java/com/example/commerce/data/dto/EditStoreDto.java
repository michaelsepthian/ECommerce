package com.example.commerce.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EditStoreDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;
}
