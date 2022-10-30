package com.example.moysklad.controller;

import com.example.moysklad.controller.dto.StorageRequestDto;
import com.example.moysklad.controller.dto.StorageResponseDto;
import com.example.moysklad.entity.Storage;
import com.example.moysklad.service.StorageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/v1/storage", produces = MediaType.APPLICATION_JSON_VALUE)
public class StorageController {
    private final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping
    public List<StorageResponseDto> getAllStorage() {
        return storageService.getAll().stream().map(StorageResponseDto::new).collect(Collectors.toList());
    }

    @PostMapping("/create")
    public StorageResponseDto createStorage(@RequestBody StorageRequestDto storageRequestDto) {
        return storageService.createStorage(storageRequestDto);
    }

    @PutMapping("/update")
    public Storage update(@RequestBody Storage storage) {
        storageService.updateStorage(storage);
        return storage;
    }

    @DeleteMapping("/delete/{id}")
    public List<StorageResponseDto> deleteById(@PathVariable Long id) {
        storageService.deleteStorage(id);
        return storageService.getAll().stream().map(StorageResponseDto::new).collect(Collectors.toList());
    }


}
