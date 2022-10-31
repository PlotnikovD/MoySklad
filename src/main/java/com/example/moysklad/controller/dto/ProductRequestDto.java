package com.example.moysklad.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ProductRequestDto {
    @NotNull(message = "Поле code не должно быть null.")
    @NotBlank(message = "Поле code не должно быть пустым.")
    @Size(min = 1, max = 100, message = "Длина поля code должно быть от 1 до 100 символ.")
    private final String code;
    @NotNull(message = "Поле name не должно быть null.")
    @NotBlank(message = "Поле name не должно быть пустым.")
    @Size(min = 1, max = 100, message = "Длина поля name должно быть от 1 до 100 символ.")
    private final String name;
    @Min(value = 0, message = "Поле lastPurchasePrise должно быть больше 0.")
    private final Double lastPurchasePrice;
    @Min(value = 0, message = "Поле lastSalePrice должно быть больше 0.")
    private final Double lastSalePrice;



    public ProductRequestDto(@JsonProperty("code") String code,
                             @JsonProperty("name") String name,
                             @JsonProperty("lastPurchasePrice") Double lastPurchasePrice,
                             @JsonProperty("lastSalePrice") Double lastSalePrice) {
        this.code = code;
        this.name = name;
        this.lastPurchasePrice = lastPurchasePrice;
        this.lastSalePrice = lastSalePrice;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Double getLastPurchasePrice() {
        return lastPurchasePrice;
    }

    public Double getLastSalePrice() {
        return lastSalePrice;
    }
}
