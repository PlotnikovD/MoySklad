package controller.dto;

import entity.Product;

public class ProductResponseDto {
    private final Long id;
    private final String code;
    private final String name;
    private final Double lastPurchasePrice;
    private final Double lastSalePrice;

    public ProductResponseDto(Product product) {
        this.id = product.getId();
        this.code = product.getCode();
        this.name = product.getName();
        this.lastPurchasePrice = product.getLastPurchasePrice();
        this.lastSalePrice = product.getLastSalePrice();
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
