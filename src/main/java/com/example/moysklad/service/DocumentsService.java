package com.example.moysklad.service;

import com.example.moysklad.controller.dto.DocumentsRequestDto;
import com.example.moysklad.controller.dto.DocumentsResponseDto;
import com.example.moysklad.entity.Documents;
import com.example.moysklad.entity.Storage;
import com.example.moysklad.exceptionhandler.exception.DocumentNotFoundException;
import com.example.moysklad.exceptionhandler.exception.StorageNotFoundException;
import com.example.moysklad.repository.DocumentsRepository;
import com.example.moysklad.repository.StorageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentsService {
    private final DocumentsRepository documentsRepository;
    private final StorageRepository storageRepository;

    public DocumentsService(DocumentsRepository documentsRepository, StorageRepository storageRepository) {
        this.documentsRepository = documentsRepository;
        this.storageRepository = storageRepository;
    }

    public DocumentsResponseDto createDocument(DocumentsRequestDto documentsRequestDto) {
        Storage firstStorage = storageRepository.findById(documentsRequestDto.getFirstStorage().getId())
                .orElseThrow(() -> new StorageNotFoundException("FIRST_STORAGE_NOT_FOUND"));
        Storage secondStorage = null;
        if(documentsRequestDto.getSecondStorage() != null) {
            secondStorage = storageRepository.findById(documentsRequestDto.getSecondStorage().getId())
                    .orElseThrow(() -> new StorageNotFoundException("SECOND_STORAGE_NOT_FOUND"));
        }
        Documents documents = new Documents(firstStorage, secondStorage,
                documentsRequestDto.getInfo(), documentsRequestDto.getType());
        documentsRepository.save(documents);
        return new DocumentsResponseDto(documents);
    }

    public List<Documents> getAll() {
        List<Documents> documents = documentsRepository.findAll();
        if (documents.isEmpty()){
            throw new DocumentNotFoundException("DOCUMENTS_LIST_IS_EMPTY");
        }
        return documentsRepository.findAll();
    }

    public void updateDocuments(Documents documents) {
        Documents updateDocument = documentsRepository.findById(documents.getId())
                .orElseThrow(() -> new DocumentNotFoundException("DOCUMENT_WITH_ID_" + documents.getId() +"_NOF_FOUND"));
        updateDocument.setFirstStorage(documents.getFirstStorage());
        updateDocument.setSecondStorage(documents.getSecondStorage());
        updateDocument.setInfo(documents.getInfo());
        updateDocument.setType(documents.getType());
        documentsRepository.save(updateDocument);
    }

    public void deleteDocument(Long id) {
        Documents documents = documentsRepository.findById(id)
                .orElseThrow(()-> new DocumentNotFoundException("DOCUMENT_BY_ID_" + id + "_DOES_NOT_EXIST "));
        documentsRepository.delete(documents);
    }
}



