package com.example.moysklad.controller;

import com.example.moysklad.controller.dto.ProductCountResponseDto;
import com.example.moysklad.controller.dto.StorageRequestDto;
import com.example.moysklad.controller.dto.StorageResponseDto;
import com.example.moysklad.entity.Storage;
import com.example.moysklad.service.StorageService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@Validated
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
    @GetMapping("info/{id}")
    public List<ProductCountResponseDto> getInfoByStorageId(@Valid @PathVariable Long id) {
        return storageService.findAllById(id);
    }

    @PostMapping
    public StorageResponseDto createStorage(@Valid @RequestBody StorageRequestDto storageRequestDto) {
        return storageService.createStorage(storageRequestDto);
    }

    @PutMapping
    public Storage update(@Valid @RequestBody Storage storage) {
        storageService.updateStorage(storage);
        return storage;
    }

    @DeleteMapping("/{id}")
    public List<StorageResponseDto> deleteById(@Valid @PathVariable Long id) {
        storageService.deleteStorage(id);
        return storageService.getAll().stream().map(StorageResponseDto::new).collect(Collectors.toList());
    }


}
