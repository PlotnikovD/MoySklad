package com.example.moysklad.controller.dto;

import java.util.List;

public class DocumentsResponseDto {
    private final Long id;
    private final Long firstStorage;
    private final Long secondStorage;
    private final List<ProductInfoDto> info;
    private final String type;

    public DocumentsResponseDto(Long id, Long firstStorage, Long secondStorage, List<ProductInfoDto> info, String type) {
        this.id = id;
        this.firstStorage = firstStorage;
        this.secondStorage = secondStorage;
        this.info = info;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public Long getFirstStorage() {
        return firstStorage;
    }

    public Long getSecondStorage() {
        return secondStorage;
    }

    public List<ProductInfoDto> getInfo() {
        return info;
    }

    public String getType() {
        return type;
    }
}
