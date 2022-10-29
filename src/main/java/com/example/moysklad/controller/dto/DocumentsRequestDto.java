package com.example.moysklad.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentsRequestDto {
    private final String movingFrom;
    private final String movingTo;
    private final Object info;
    private final String type;

    public DocumentsRequestDto(@JsonProperty("movingFrom") String movingFrom,
                               @JsonProperty("movingTo") String movingTo,
                               @JsonProperty("info") Object info,
                               @JsonProperty("type") String type) {
        this.movingFrom = movingFrom;
        this.movingTo = movingTo;
        this.info = info;
        this.type = type;
    }

    public String getMovingFrom() {
        return movingFrom;
    }

    public String getMovingTo() {
        return movingTo;
    }

    public Object getInfo() {
        return info;
    }

    public String getType() {
        return type;
    }
}
