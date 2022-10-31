package com.example.moysklad.service;

import com.example.moysklad.controller.dto.DocumentsRequestDto;
import com.example.moysklad.controller.dto.DocumentsResponseDto;
import com.example.moysklad.entity.Documents;
import com.example.moysklad.exceptionhandler.exception.DocumentNotFoundException;
import com.example.moysklad.repository.DocumentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentsService {
    private final DocumentsRepository documentsRepository;

    public DocumentsService(DocumentsRepository documentsRepository) {
        this.documentsRepository = documentsRepository;
    }

    public DocumentsResponseDto createDocument(DocumentsRequestDto documentsRequestDto) {
        Documents documents = new Documents(documentsRequestDto.getFirstStorage(), documentsRequestDto.getSecondStorage(),
                documentsRequestDto.getInfo(), documentsRequestDto.getType());
        documentsRepository.save(documents);
        return new DocumentsResponseDto(documents);
    }

    public List<Documents> getAll() {
        return documentsRepository.findAll();
    }

    public void updateDocuments(Documents documents) {
        Documents updateDocument = documentsRepository.findById(documents.getId())
                .orElseThrow(() -> new DocumentNotFoundException("DOCUMENT_NOF_FOUND"));
        updateDocument.setFirstStorage(documents.getFirstStorage());
        updateDocument.setSecondStorage(documents.getSecondStorage());
        updateDocument.setInfo(updateDocument.getInfo());
        updateDocument.setType(updateDocument.getType());
        documentsRepository.save(updateDocument);
    }

    public void deleteDocument(Long id) {
        documentsRepository.deleteById(id);
    }
}



