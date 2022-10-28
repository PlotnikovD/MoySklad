package controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import entity.Storage;

public class StorageRequestDto {
    private final String name;

    public StorageRequestDto(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

