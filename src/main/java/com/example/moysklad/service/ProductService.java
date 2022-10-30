package com.example.moysklad.service;

import com.example.moysklad.controller.dto.ProductRequestDto;
import com.example.moysklad.controller.dto.ProductResponseDto;
import com.example.moysklad.entity.Product;
import com.example.moysklad.exceptionhandler.exception.ProductNotFoundException;
import com.example.moysklad.repository.ProductRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = new Product(productRequestDto.getCode(), productRequestDto.getName(),
                productRequestDto.getLastPurchasePrice(), productRequestDto.getLastSalePrice());
        productRepository.save(product);
        return new ProductResponseDto(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public List<Product> getAllByName(String name) {
       return productRepository.findByName(name);
    }

    public void updateProduct(Product product) {
        Product updateProduct = productRepository.findById(product.getId())
                .orElseThrow(() -> new ProductNotFoundException("PRODUCT_NOT_FOUND"));
        updateProduct.setCode(product.getCode());
        updateProduct.setName(product.getName());
        updateProduct.setLastPurchasePrice(product.getLastPurchasePrice());
        updateProduct.setLastSalePrice(product.getLastSalePrice());
        productRepository.save(updateProduct);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);

    }
}
