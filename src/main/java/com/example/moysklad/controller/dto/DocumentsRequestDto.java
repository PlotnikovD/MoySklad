package com.example.moysklad.controller.dto;

import com.example.moysklad.entity.Storage;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DocumentsRequestDto {
    private final Storage firstStorage;
    private final Storage secondStorage;
    private final List<ProductInfoDto> info;
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
