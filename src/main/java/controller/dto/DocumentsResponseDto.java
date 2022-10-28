package controller.dto;

import entity.Documents;

public class DocumentsResponseDto {
    private final Long id;
    private final String movingFrom;
    private final String movingTo;
    private final Object info;
    private final String type;

    public DocumentsResponseDto(Documents documents) {
        this.id = documents.getId();
        this.movingFrom = documents.getMovingFrom();
        this.movingTo = documents.getMovingTo();
        this.info = documents.getInfo();
        this.type = documents.getType();
    }

    public Long getId() {
        return id;
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
