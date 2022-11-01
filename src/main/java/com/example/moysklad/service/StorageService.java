package com.example.moysklad.service;

import com.example.moysklad.controller.dto.*;
import com.example.moysklad.entity.Documents;
import com.example.moysklad.entity.Product;
import com.example.moysklad.entity.Storage;
import com.example.moysklad.exceptionhandler.exception.StorageNotFoundException;
import com.example.moysklad.repository.DocumentsRepository;
import com.example.moysklad.repository.ProductRepository;
import com.example.moysklad.repository.StorageRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StorageService {
    private final StorageRepository storageRepository;
    private final DocumentsRepository documentsRepository;
    private final ProductRepository productRepository;

    public StorageService(StorageRepository storageRepository, DocumentsRepository documentsRepository, ProductRepository productRepository) {
        this.storageRepository = storageRepository;
        this.documentsRepository = documentsRepository;
        this.productRepository = productRepository;
    }

    public StorageResponseDto createStorage(StorageRequestDto storageRequestDto) {
        Storage storage = new Storage()
                .setName(storageRequestDto.getName());
        storageRepository.save(storage);
        return new StorageResponseDto(storage);
    }

    public List<Storage> getAll() {
        List<Storage> storages = storageRepository.findAll();
        if(storages.isEmpty()) {
            throw new StorageNotFoundException("STORAGE_LIST_IS_EMPTY");
        }
        return storageRepository.findAll();
    }

    public List<ProductCountResponseDto> findAllById(Long id) {
        HashMap<Long, Integer> productHashMap = new HashMap<>();
        if(id != null) {
            List<Documents> documents = documentsRepository.findByFirstStorageId(id);
            documents.forEach(document -> {
                if (document.getType() == ProductInfoDto.Types.GET) {
                    document.getInfo().forEach(info -> {
                        if (productHashMap.containsKey(info.getId())) {
                            Integer count = productHashMap.get(info.getId());
                            productHashMap.put(info.getId(), count + info.getCount());
                        } else {
                            productHashMap.put(info.getId(), info.getCount());
                        }
                    });
                } else {
                    document.getInfo().forEach(info -> {
                        if (productHashMap.containsKey(info.getId())) {
                            Integer count = productHashMap.get(info.getId());
                            productHashMap.put(info.getId(), count - info.getCount());
                        } else {
                            productHashMap.put(info.getId(), -info.getCount());
                        }
                    });
                }
            });
            List<Documents> secondStorageDocuments = documentsRepository.findBySecondStorageId(id);
            secondStorageDocuments.forEach(document -> {
                document.getInfo().forEach(info -> {
                    if (productHashMap.containsKey(info.getId())) {
                        Integer count = productHashMap.get(info.getId());
                        productHashMap.put(info.getId(), count + info.getCount());
                    } else {
                        productHashMap.put(info.getId(), info.getCount());
                    }
                });
            });
        }
        List<Product> products = productRepository.findByIdIn(productHashMap.keySet());
        return products.stream().map(product ->
                new ProductCountResponseDto(product, productHashMap.get(product.getId()))).collect(Collectors.toList());
    }

    public void updateStorage(Storage storage) {
        Storage updateStorage = storageRepository.findById(storage.getId())
                .orElseThrow(() -> new StorageNotFoundException("STORAGE_WITH_ID_" + storage.getId() + "_NOT_FOUND"));
        updateStorage.setName(storage.getName());
        storageRepository.save(updateStorage);
    }
    public void deleteStorage(Long id){
        Storage storage = storageRepository.findById(id)
                .orElseThrow(()-> new StorageNotFoundException("STORAGE_BY_ID_" + id + "_DOES_NOT_EXIST"));
        storageRepository.delete(storage);
    }

}
