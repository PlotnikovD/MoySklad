package com.example.moysklad.controller.dto;

import com.example.moysklad.entity.Storage;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class DocumentsRequestDto {
    @NotNull
    private final Storage firstStorage;
    @NotNull
    private final Storage secondStorage;
    @NotNull
    private final List<ProductInfoDto> info;
    @NotNull(message = "Поле type  не полжно быть null и иметь значение GET, SELL или TRANSFER.")
    @NotBlank(message = "Поле type  не должно быть пустым и иметь значение GET, SELL или TRANSFER.")
    @Size(min = 3, max = 8, message = "Поле type должно иметь значение GET, SELL или TRANSFER.")
    private final String type;

    public DocumentsRequestDto(@JsonProperty("firstStorage") Storage firstStorage,
                               @JsonProperty("secondStorage") Storage secondStorage,
                               @JsonProperty("info") List<ProductInfoDto> info,
                               @JsonProperty("type") String type) {
        this.firstStorage = firstStorage;
        this.secondStorage = secondStorage;
        this.info = info;
        this.type = type;
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
