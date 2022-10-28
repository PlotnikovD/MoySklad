package service;

import controller.dto.ProductRequestDto;
import controller.dto.ProductResponseDto;
import entity.Product;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

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
}
