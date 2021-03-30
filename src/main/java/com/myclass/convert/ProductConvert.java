package com.myclass.convert;

import com.myclass.dto.ProductDto;
import com.myclass.entity.Product;

public class ProductConvert {
    public Product toEntity(ProductDto productDto){
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setSummary(productDto.getSummary());
        product.setType(productDto.getType());
        product.setContent(productDto.getContent());
        product.setImage(productDto.getImage());
        return product;
    }

    public ProductDto toDto(Product product){

        ProductDto productDto = new ProductDto();
        if (product.getId() != null){
            productDto.setId(product.getId());
        }
        productDto.setTitle(product.getTitle());
        productDto.setSummary(product.getSummary());
        productDto.setType(product.getType());
        productDto.setContent(product.getContent());
        productDto.setImage(product.getImage());
        return productDto;
    }
    public Product toEntity(ProductDto productDto, Product product){
        product.setTitle(productDto.getTitle());
        product.setSummary(productDto.getSummary());
        product.setType(productDto.getType());
        product.setContent(productDto.getContent());
        product.setImage(productDto.getImage());
        return product;
    }

}
