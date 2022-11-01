package com.example.moysklad.controller.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductInfoDto {
    @NotNull
    private final Long id;
    @NotNull(message = "Поле name не должно быть null.")
    @Min(value = 0, message = "Поле count должно быть больше 0.")
    private final Integer count;
    @NotBlank(message = "Поле name не должно быть пустым.")
    //@Size(min = 1, max = 100, message = "Длина поля name должно быть от 1 до 100 символ.")
    private final String name;
    @NotNull(message = "Поле cost не должно быть null.")
    @Min(value = 0, message = "Поле cost должно быть больше 0.")
    private final Double cost;

    public ProductInfoDto(Long id, Integer count, String name, Double cost) {
        this.id = id;
        this.count = count;
        this.name = name;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public Integer getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }

    public enum Types {
        GET, SELL, TRANSFER
    }
}
