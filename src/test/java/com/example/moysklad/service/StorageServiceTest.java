package com.example.moysklad.service;

import com.example.moysklad.controller.dto.StorageRequestDto;
import com.example.moysklad.entity.Storage;
import com.example.moysklad.exceptionhandler.exception.StorageNotFoundException;
import com.example.moysklad.repository.StorageRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
class StorageServiceTest {
    @Autowired
    private StorageService storageService;
    @MockBean
    private StorageRepository storageRepository;
    private static Storage firstStorage;
    private static Storage secondStorage;
    private static List<Storage> storageList;

    @BeforeEach
    void SetUp() {
        firstStorage = new Storage()
                .setName("storage_one");
        secondStorage = new Storage()
                .setName("second_storage");
        storageList = List.of(firstStorage, secondStorage);
    }

    @Test
    void createStorageShouldReturnStorageResponseDto() {

        StorageRequestDto storageRequestDto = new StorageRequestDto(firstStorage.getId(), firstStorage.getName());
        Mockito.when(storageRepository.save(firstStorage)).thenReturn(new Storage());
        Assertions.assertEquals(storageRequestDto.getName(), storageService.createStorage(storageRequestDto).getName());
    }

    @Test
    void createStorageSaveShouldBeCalledOnce() {
        StorageRequestDto storageRequestDto = new StorageRequestDto(firstStorage.getId(), firstStorage.getName());
        storageService.createStorage(storageRequestDto);
        Mockito.verify(storageRepository).save(Mockito.any());
    }

    @Test
    void getAllStorageCountShouldBeEqualsFindAllRepositoryCount() {
        Mockito.when(storageRepository.findAll()).thenReturn(storageList);
        Assertions.assertEquals(2, storageService.getAll().size());
    }

    @Test
    void getAllServiceShouldThrowExceptionWhenListIsEmpty() {
        StorageNotFoundException exception = Assertions.assertThrows(StorageNotFoundException.class, () -> {
            storageService.getAll();
        });
        Assertions.assertEquals("STORAGE_LIST_IS_EMPTY", exception.getMessage());

    }

    @Test
    void updateStorageShouldThrowExceptionIfIdNotFound() {
        StorageNotFoundException exception = Assertions.assertThrows(StorageNotFoundException.class, () -> {
            storageService.updateStorage(firstStorage);
        });
        Assertions.assertEquals("STORAGE_WITH_ID_" + firstStorage.getId() + "_NOT_FOUND",
                exception.getMessage());
    }

    @Test
    void deleteStorageShouldThrowExceptionIfIdNotFound() {
        Long id = 6L;
        StorageNotFoundException exception = Assertions.assertThrows(StorageNotFoundException.class, () -> {
            storageService.deleteStorage(id);
        });
        Assertions.assertEquals("STORAGE_BY_ID_" + id + "_DOES_NOT_EXIST", exception.getMessage());
    }
}
