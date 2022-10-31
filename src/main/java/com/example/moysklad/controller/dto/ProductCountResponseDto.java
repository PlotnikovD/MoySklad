package com.example.moysklad.controller.dto;


import com.example.moysklad.entity.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductCountResponseDto {
    @NotNull
    private final Long id;
    @NotBlank(message = "Поле code не должно быть пустым.")
    @Size(min = 1, max = 100, message = "Длина поля code должно быть от 1 до 100 символ.")
    private final String code;
    @NotBlank(message = "Поле name не должно быть пустым.")
    @Size(min = 1, max = 100, message = "Длина поля name должно быть от 1 до 100 символ.")
    private final String name;
    @Min(value = 0, message = "Поле lastPurchasePrise должно быть больше 0.")
    private final Double lastPurchasePrice;
    @Min(value = 0, message = "Поле lastSalePrice должно быть больше 0.")
    private final Double lastSalePrice;
    private final Integer count;

    public ProductCountResponseDto(Product product, Integer count) {
        this.id = product.getId();
        this.code = product.getCode();
        this.name = product.getName();
        this.lastPurchasePrice = product.getLastPurchasePrice();
        this.lastSalePrice = product.getLastSalePrice();
        this.count = count;
    }

    public Long getId() {
        return id;
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
