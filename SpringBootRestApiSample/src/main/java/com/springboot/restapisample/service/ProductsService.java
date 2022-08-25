package com.springboot.restapisample.service;

import java.util.List;
import com.springboot.restapisample.dto.ProductSaveResponseDto;
import com.springboot.restapisample.dto.ProductRequestDto;
import com.springboot.restapisample.dto.ProductResponseDto;
import com.springboot.restapisample.dto.ProductUpdateDto;
import com.springboot.restapisample.dto.ProductDeleteDto;
import com.springboot.restapisample.response.ResponseMessages;

public interface ProductsService
{
    ResponseMessages<ProductSaveResponseDto> insertProducts(ProductRequestDto productRequestDto);
    ResponseMessages<List<ProductResponseDto>> getAllProducts();
    ResponseMessages<ProductResponseDto> getProductById(Long productId);
    ResponseMessages<ProductUpdateDto> updateProduct(Long productId, ProductRequestDto productRequestDto);
    ResponseMessages<ProductDeleteDto> deleteProduct(Long productId);
}
