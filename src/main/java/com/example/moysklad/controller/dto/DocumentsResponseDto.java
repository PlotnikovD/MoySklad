package com.example.moysklad.controller.dto;

import com.example.moysklad.entity.Documents;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class DocumentsResponseDto {
    @NotNull
    private final Long id;
    @NotNull
    private final StorageResponseDto firstStorage;

    private final StorageResponseDto secondStorage;
    @NotNull(message = "Поле info  не полжно быть null.")
    private final List<ProductInfoDto> info;

    @NotBlank(message = "Поле type  не должно быть пустым и иметь значение GET, SELL или TRANSFER.")
    @NotNull
    //@Size(min = 3, max = 8, message = "Поле type должно иметь значение GET, SELL или TRANSFER.")
    private final ProductInfoDto.Types type;

    public DocumentsResponseDto(Long id, StorageResponseDto firstStorage, StorageResponseDto secondStorage,
                                List<ProductInfoDto> info, ProductInfoDto.Types type) {
        this.id = id;
        this.firstStorage = firstStorage;
        this.secondStorage = secondStorage;
        this.info = info;
        this.type = type;
    }

    public DocumentsResponseDto(Documents documents) {
        this.id = documents.getId();
        this.firstStorage = new StorageResponseDto(documents.getFirstStorage());
        this.secondStorage = documents.getSecondStorage() != null ?
                new StorageResponseDto(documents.getSecondStorage()) : null;
        this.info = documents.getInfo();
        this.type = documents.getType();

    }

    public Long getId() {
        return id;
    }

    public StorageResponseDto getFirstStorage() {
        return firstStorage;
    }

    public StorageResponseDto getSecondStorage() {
        return secondStorage;
    }

    public List<ProductInfoDto> getInfo() {
        return info;
    }

    public ProductInfoDto.Types getType() {
        return type;
    }
}
