package com.example.moysklad.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StorageRequestDto {
    @NotNull(message = "Поле name не должно быть null.")
    @NotBlank(message = "Поле name не должно быть пустым.")
    @Size(min = 1, max = 50, message = "Длина поля name должно быть от 1 до 50 символ.")
    private final String name;

    public StorageRequestDto(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

