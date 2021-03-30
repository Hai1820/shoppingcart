package com.myclass.service.impl;

import com.myclass.convert.ProductConvert;
import com.myclass.dto.ProductDto;
import com.myclass.entity.Product;
import com.myclass.repository.ProductRepository;
import com.myclass.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductConvert productConvert;
    @Override
    public List<ProductDto> getAll() {
        List<ProductDto> productDtos =new ArrayList<>();
       try {
           List<Product> products = productRepository.findAll();


           for (Product product:products
                ) {
               ProductDto productDto = productConvert.toDto(product);
               productDtos.add(productDto);
           }

       }catch (Exception e){
           e.getMessage();
       }
        return productDtos;
    }

    @Override
    public Product saveOrUpdate(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto findById(Product product) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
