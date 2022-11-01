package com.example.moysklad.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentsRequestDto {
    @NotNull
    private final StorageRequestDto firstStorage;
    private final StorageRequestDto secondStorage;
    @NotNull
    private final List<ProductInfoDto> info;
    @NotNull
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
