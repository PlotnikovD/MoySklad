package com.example.moysklad.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DocumentsRequestDto {
    private final Long firstStorage;
    private final Long secondStorage;
    private final List<ProductInfoDto> info;
    private final String type;

    public DocumentsRequestDto(@JsonProperty("firstStorage") Long firstStorage,
                               @JsonProperty("secondStorage") Long secondStorage,
                               @JsonProperty("info") List<ProductInfoDto> info,
                               @JsonProperty("type") String type) {
        this.firstStorage = firstStorage;
        this.secondStorage = secondStorage;
        this.info = info;
        this.type = type;
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
