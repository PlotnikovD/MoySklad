package service;

import controller.dto.ProductRequestDto;
import controller.dto.ProductResponseDto;
import entity.Product;
import exceptionhandler.exception.ProductNotFoundException;
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
