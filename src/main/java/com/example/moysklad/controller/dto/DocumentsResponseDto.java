package com.example.moysklad.controller.dto;

import com.example.moysklad.entity.Documents;
import com.example.moysklad.entity.Storage;

import java.util.List;

public class DocumentsResponseDto {
    private final Long id;
    private final Storage firstStorage;
    private final Storage secondStorage;
    private final List<ProductInfoDto> info;
    private final String type;

    public DocumentsResponseDto(Long id, Storage firstStorage, Storage secondStorage, List<ProductInfoDto> info, String type) {
        this.id = id;
        this.firstStorage = firstStorage;
        this.secondStorage = secondStorage;
        this.info = info;
        this.type = type;
    }

    public DocumentsResponseDto(Documents documents) {
        this.id = documents.getId();
        this.firstStorage = documents.getFirstStorage();
        this.secondStorage = documents.getSecondStorage();
        this.info = documents.getInfo();
        this.type = documents.getType();
    }

    public Long getId() {
        return id;
    }

    public Storage getFirstStorage() {
        return firstStorage;
    }

    public Storage getSecondStorage() {
        return secondStorage;
    }

    public List<ProductInfoDto> getInfo() {
        return info;
    }

    public String getType() {
        return type;
    }
}
