package com.example.moysklad.controller.dto;

import com.example.moysklad.entity.Documents;
import com.example.moysklad.entity.Storage;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class DocumentsResponseDto {
    @NotNull
    private final Long id;
    @NotNull
    private final Storage firstStorage;
    @NotNull
    private final Storage secondStorage;
    @NotNull(message = "Поле info  не полжно быть null.")
    private final List<ProductInfoDto> info;
    @NotNull(message = "Поле type  не полжно быть null и иметь значение GET, SELL или TRANSFER.")
    @NotBlank(message = "Поле type  не должно быть пустым и иметь значение GET, SELL или TRANSFER.")
    @Size(min = 3, max = 8, message = "Поле type должно иметь значение GET, SELL или TRANSFER.")
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
