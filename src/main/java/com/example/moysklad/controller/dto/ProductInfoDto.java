package com.example.moysklad.controller.dto;

public class ProductInfoDto {
    private final Long id;
    private final Integer count;
    private final String name;
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
