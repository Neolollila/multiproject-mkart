package com.devmandrik.productservice.mapper;

import com.devmandrik.productservice.dto.ProductRequest;
import com.devmandrik.productservice.dto.ProductResponse;
import com.devmandrik.productservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product productRequestToProduct(ProductRequest productRequest);

    ProductResponse productToProductResponse(Product product);
}
