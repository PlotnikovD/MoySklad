package controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ProductRequestDto {

    private final String code;
    private final String name;
    private final Double lastPurchasePrice;
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
