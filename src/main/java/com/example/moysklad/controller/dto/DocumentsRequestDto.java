package com.example.moysklad.controller.dto;

import com.example.moysklad.entity.Storage;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class DocumentsRequestDto {
    @NotNull
    private final StorageRequestDto firstStorage;

    private final StorageRequestDto secondStorage;
    @NotNull
    private final List<ProductInfoDto> info;

    @NotBlank(message = "Поле type  не должно быть пустым и иметь значение GET, SELL или TRANSFER.")
    @Size(min = 3, max = 8, message = "Поле type должно иметь значение GET, SELL или TRANSFER.")
    private final ProductInfoDto.Types type;

    public DocumentsRequestDto(@JsonProperty("firstStorage") StorageRequestDto firstStorage,
                               @JsonProperty("secondStorage") StorageRequestDto secondStorage,
                               @JsonProperty("info") List<ProductInfoDto> info,
                               @JsonProperty("type") ProductInfoDto.Types type) {
        this.firstStorage = firstStorage;
        this.secondStorage = secondStorage;
        this.info = info;
        this.type = type;
    }


    public StorageRequestDto getFirstStorage() {
        return firstStorage;
    }

    public StorageRequestDto getSecondStorage() {
        return secondStorage;
    }

    public List<ProductInfoDto> getInfo() {
        return info;
    }

    public ProductInfoDto.Types getType() {
        return type;
    }
}
