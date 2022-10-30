package com.example.moysklad.controller.dto;

public class ProductInfoDto {
    private final Integer count;
    private final String name;
    private final Double cost;

    public ProductInfoDto(Integer count, String name, Double cost) {
        this.count = count;
        this.name = name;
        this.cost = cost;
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
}
