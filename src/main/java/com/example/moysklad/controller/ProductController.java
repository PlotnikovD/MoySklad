package com.example.moysklad.controller;

import com.example.moysklad.controller.dto.ProductRequestDto;
import com.example.moysklad.controller.dto.ProductResponseDto;
import com.example.moysklad.entity.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.moysklad.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAll().stream().map(ProductResponseDto::new).collect(Collectors.toList());
    }
    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);

    }
    @PutMapping("/update")
    public Product update(@RequestBody Product product){
        productService.updateProduct(product);
        return product;
    }

}