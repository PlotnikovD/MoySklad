package com.example.moysklad.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "code", length = 100)
    private String code;
    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "last_purchase_price")
    private Double lastPurchasePrice;
    @Column(name = "last_sale_price")
    private Double lastSalePrice;

    public Product() {
    }

    public Product(String code, String name, Double lastPurchasePrice, Double lastSalePrice) {
        this.code = code;
        this.name = name;
        this.lastPurchasePrice = lastPurchasePrice;
        this.lastSalePrice = lastSalePrice;
    }

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Product setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Double getLastPurchasePrice() {
        return lastPurchasePrice;
    }

    public Product setLastPurchasePrice(Double lastPurchasePrice) {
        this.lastPurchasePrice = lastPurchasePrice;
        return this;
    }

    public Double getLastSalePrice() {
        return lastSalePrice;
    }

    public Product setLastSalePrice(Double lastSalePrice) {
        this.lastSalePrice = lastSalePrice;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", lastPurchasePrice=" + lastPurchasePrice +
                ", lastSalePrice=" + lastSalePrice +
                '}';
    }
}
