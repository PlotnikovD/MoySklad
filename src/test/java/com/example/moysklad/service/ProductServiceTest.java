package com.example.moysklad.service;

import com.example.moysklad.controller.dto.ProductRequestDto;
import com.example.moysklad.controller.dto.ProductResponseDto;
import com.example.moysklad.entity.Product;
import com.example.moysklad.exceptionhandler.exception.ProductNotFoundException;
import com.example.moysklad.repository.ProductRepository;
import com.sun.source.tree.ModuleTree;
import liquibase.pro.packaged.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productService;
    @MockBean
    private ProductRepository productRepository;

    private static Product firstProduct;
    private static Product secondProduct;
    private static List<Product> products;

    @BeforeEach
    void setUp() {
        firstProduct = new Product()
                .setId(1L)
                .setCode("1k1")
                .setName("pedal")
                .setLastPurchasePrice(144.5)
                .setLastSalePrice(190.31);

        secondProduct = new Product()
                .setId(2L)
                .setCode("5k1")
                .setName("brakepads")
                .setLastPurchasePrice(1454.5)
                .setLastSalePrice(1630.98);

        products = List.of(firstProduct, secondProduct);
    }

    @Test
    void createProductShouldReturnProductResponseDto() {
        ProductRequestDto productRequestDto = new ProductRequestDto(firstProduct.getCode(),
                firstProduct.getName(), firstProduct.getLastPurchasePrice(), firstProduct.getLastSalePrice());
        Mockito.when(productRepository.save(firstProduct)).thenReturn(new Product());
        Assertions.assertEquals(productRequestDto.getName(),
                productService.createProduct(productRequestDto).getName());
    }

    @Test
    void createProductSaveShouldBeCalledOnce() {
        ProductRequestDto productRequestDto = new ProductRequestDto(firstProduct.getCode(),
                firstProduct.getName(), firstProduct.getLastPurchasePrice(), firstProduct.getLastSalePrice());
        productService.createProduct(productRequestDto);
        Mockito.verify(productRepository).save(Mockito.any());
    }

    @Test
    void getAllServiceCountShouldBeEqualsGetAllRepositoryCount() {
        Mockito.when(productRepository.findAll()).thenReturn(products);
        Assertions.assertEquals(2, productService.getAll().size());
    }

    @Test
    void getAllServiceShouldThrowExceptionIfListIsEmpty() {
        ProductNotFoundException exception = Assertions.assertThrows(ProductNotFoundException.class, () -> {
            productService.getAll();
        });
        Assertions.assertEquals("PRODUCT_LIST_IS_EMPTY", exception.getMessage());
    }

        @Test
        void getAllByNameShouldThrowExceptionIfListIsEmpty () {
            String name = "disk";
            ProductNotFoundException exception = Assertions.assertThrows(ProductNotFoundException.class, () -> {
                productService.getAllByName(name);
            });
            Assertions.assertEquals("PRODUCT_WITH_NAME_" + name.toUpperCase() + "_NOT FOUND",
                    exception.getMessage());
        }

        @Test
        void updateProductServiceShouldThrowExceptionIfIdNotFound () {
            ProductNotFoundException exception = Assertions.assertThrows(ProductNotFoundException.class, () -> {
                productService.updateProduct(firstProduct);
            });
            Assertions.assertEquals("PRODUCT_BY_ID_" + firstProduct.getId() + "_NOT_FOUND",
                    exception.getMessage());
        }
        @Test
        void deleteProductShouldThrowExceptionWhenIdNotFound () {
            Long id = 6L;
            ProductNotFoundException exception = Assertions.assertThrows(ProductNotFoundException.class, () -> {
                productService.deleteProduct(id);
            });
            Assertions.assertEquals("PRODUCT_BY_ID_" + id + "_DOES_NOT_EXIST ",
                    exception.getMessage());
        }
    }



