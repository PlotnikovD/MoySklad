package com.example.moysklad.controller.dto;


import com.example.moysklad.entity.Storage;

public class StorageResponseDto {
    private final Long id;
    private final String name;

    public StorageResponseDto(Storage storage) {
        this.id = storage.getId();
        this.name = storage.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
