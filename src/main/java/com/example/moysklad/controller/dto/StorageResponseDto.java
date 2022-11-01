package com.example.moysklad.controller.dto;


import com.example.moysklad.entity.Storage;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StorageResponseDto {
    @NotNull
    private final Long id;

    @NotBlank(message = "Поле name не должно быть пустым.")
    @Size(min = 1, max = 50, message = "Длина поля name должно быть от 1 до 50 символ.")
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
