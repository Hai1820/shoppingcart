package com.myclass.service;

import com.myclass.dto.ProductDto;
import com.myclass.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductDto> getAll();
    Product saveOrUpdate(ProductDto productDto);
    ProductDto findById(Product product);
    void deleteById(Long id);
}
