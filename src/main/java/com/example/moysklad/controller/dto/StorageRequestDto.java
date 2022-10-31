package com.example.moysklad.controller.dto;



public class StorageRequestDto {
    private final Long id;
    private final String name;

    public StorageRequestDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

