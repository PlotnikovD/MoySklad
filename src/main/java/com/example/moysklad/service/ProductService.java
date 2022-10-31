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
        Product product = new Product()
                .setCode(productRequestDto.getCode())
                .setName(productRequestDto.getName())
                .setLastPurchasePrice(productRequestDto.getLastPurchasePrice())
                .setLastSalePrice(productRequestDto.getLastSalePrice());
        productRepository.save(product);
        return new ProductResponseDto(product);
    }

    public List<Product> getAll() {
        List<Product> product = productRepository.findAll();
        if (product.isEmpty()) {
            throw new ProductNotFoundException("PRODUCT_LIST_IS_EMPTY");
        }
        return productRepository.findAll();
    }

    public List<Product> getAllByName(String name) {
        List<Product> product = productRepository.findByName(name);
        if (product.isEmpty()) {
            throw new ProductNotFoundException("PRODUCT_WITH_NAME_" + name.toUpperCase() + "_NOT FOUND");
        }
        return productRepository.findByName(name);
    }

    public void updateProduct(Product product) {
        Product updateProduct = productRepository.findById(product.getId())
                .orElseThrow(() -> new ProductNotFoundException("PRODUCT_BY_ID_" + product.getId() + "_NOT_FOUND"));
        updateProduct.setCode(product.getCode());
        updateProduct.setName(product.getName());
        updateProduct.setLastPurchasePrice(product.getLastPurchasePrice());
        updateProduct.setLastSalePrice(product.getLastSalePrice());
        productRepository.save(updateProduct);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("PRODUCT_BY_ID_" + id + "_DOES_NOT_EXIST "));
        productRepository.delete(product);

    }
}
