package com.devmandrik.productservice.service;

import com.devmandrik.productservice.dto.ProductRequest;
import com.devmandrik.productservice.dto.ProductResponse;
import com.devmandrik.productservice.mapper.ProductMapper;
import com.devmandrik.productservice.model.Product;
import com.devmandrik.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    public void createProduct(ProductRequest productRequest) {

        Product product = productMapper.productRequestToProduct(productRequest);

        productRepository.save(product);
        log.info("Product {} is created", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(productMapper::productToProductResponse)
                .toList();
    }
}
