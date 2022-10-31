package com.example.moysklad.controller;

import com.example.moysklad.controller.dto.DocumentsRequestDto;
import com.example.moysklad.controller.dto.DocumentsResponseDto;
import com.example.moysklad.entity.Documents;
import com.example.moysklad.service.DocumentsService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
@RequestMapping(value = "/api/v1/documents", produces = MediaType.APPLICATION_JSON_VALUE)
public class DocumentsController {
    private final DocumentsService documentsService;

    public DocumentsController(DocumentsService documentsService) {
        this.documentsService = documentsService;
    }
    @GetMapping
    public List<DocumentsResponseDto> getAllDocuments(){
        return documentsService.getAll().stream().map(DocumentsResponseDto::new).collect(Collectors.toList());
    }
    @PostMapping("/create")
    public DocumentsResponseDto createDocument(@Valid @RequestBody DocumentsRequestDto documentsRequestDto){
        return documentsService.createDocument(documentsRequestDto);
    }
    @PutMapping("/update")
    public Documents updateDocument(@Valid @RequestBody Documents documents){
        documentsService.updateDocuments(documents);
        return documents;
    }
    @DeleteMapping("/delete/{id}")
    public List<DocumentsResponseDto> deleteById(@Valid @PathVariable Long id){
        documentsService.deleteDocument(id);
        return documentsService.getAll().stream().map(DocumentsResponseDto::new).collect(Collectors.toList());
    }
}
