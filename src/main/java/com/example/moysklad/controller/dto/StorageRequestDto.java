package com.example.moysklad.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class StorageRequestDto  {
    private final Long id;
    @NotBlank(message = "Поле name не должно быть пустым.")
    @Size(min = 1, max = 50, message = "Длина поля name должно быть от 1 до 50 символ.")
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

