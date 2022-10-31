package com.example.moysklad.service;

import com.example.moysklad.controller.dto.StorageRequestDto;
import com.example.moysklad.controller.dto.StorageResponseDto;
import com.example.moysklad.entity.Storage;
import com.example.moysklad.exceptionhandler.exception.StorageNotFoundException;
import com.example.moysklad.repository.StorageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageService {
    private final StorageRepository storageRepository;

    public StorageService(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    public StorageResponseDto createStorage(StorageRequestDto storageRequestDto) {
        Storage storage = new Storage()
                .setName(storageRequestDto.getName());
        storageRepository.save(storage);
        return new StorageResponseDto(storage);
    }


    public List<Storage> getAll() {
        return storageRepository.findAll();
    }

    public void updateStorage(Storage storage) {
        Storage updateStorage = storageRepository.findById(storage.getId())
                .orElseThrow(() -> new StorageNotFoundException("STORAGE_NOT_FOUND"));
        updateStorage.setName(storage.getName());
        storageRepository.save(updateStorage);
    }
    public void deleteStorage(Long id){
        storageRepository.deleteById(id);
    }

}
