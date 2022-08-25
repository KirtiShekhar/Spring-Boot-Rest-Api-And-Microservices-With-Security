package com.springboot.restapisample.serviceImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyLong;
import java.util.List;
import java.util.Optional;

import com.springboot.restapisample.AppTest;
import com.springboot.restapisample.dto.*;
import com.springboot.restapisample.entity.Products;
import com.springboot.restapisample.mockdata.ProductMockData;
import com.springboot.restapisample.repository.ProductsRepository;
import com.springboot.restapisample.response.ResponseMessages;
import com.springboot.restapisample.service.serviceImplementation.ProductsServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = AppTest.class)
public class ProductsServiceImplementationTest extends ProductMockData
{
    @Mock
    ProductsRepository productsRepository;

    @InjectMocks
    ProductsServiceImplementation productsServiceImplementation;

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    @DisplayName("Insert Product : Positive")
    void SaveItemTest_Positive()
    {
        // context
        Mockito.when(productsRepository.save(Mockito.any(Products.class))).thenReturn(mockProductsData());
        //event
        ResponseMessages<ProductSaveResponseDto> savedProductResponse = productsServiceImplementation.insertProducts(mockProductRequestDto());
        //outcome
        assertNotNull(savedProductResponse.getData());
    }

    @Test
    @DisplayName("Insert Product : Negative")
    void SaveItemTest_Negative()
    {
        // context
        Mockito.when(productsRepository.save(Mockito.any(Products.class))).thenReturn(null);
        //event
        ResponseMessages<ProductSaveResponseDto> savedProductResponse = productsServiceImplementation.insertProducts(mockProductRequestDto());
        //outcome
        assertNotNull(savedProductResponse.getData());
    }

    @Test
    @DisplayName("Get all Products Stored : Positive")
    void GetAllItemsItemTest_Positive()
    {
        List<Products> ProductResponseListPositive = mockProductResponseListPositiveData();
        // context
        Mockito.when(productsRepository.findAll()).thenReturn(ProductResponseListPositive);
        //event
        ResponseMessages<List<ProductResponseDto>> savedProducts = productsServiceImplementation.getAllProducts();
        //outcome
        assertEquals(ProductResponseListPositive.size(),savedProducts.getData().size());
    }

    @Test
    @DisplayName("Get all Products Stored : Negative")
    void GetAllItemsItemTest_Negative()
    {
        List<Products> ProductResponseListNegative = mockProductResponseListNegativeData();
        // context
        Mockito.when(productsRepository.findAll()).thenReturn(ProductResponseListNegative);
        //event
        ResponseMessages<List<ProductResponseDto>> savedProducts = productsServiceImplementation.getAllProducts();
        //outcome
        assertEquals(ProductResponseListNegative.size(),savedProducts.getData().size());
    }

    @Test
    @DisplayName("Get Product Stored By Id : Positive")
    void GetProductByIdTest_Positive()
    {
        Products products = mockProductsData();
        // context
        Mockito.when(productsRepository.findById(1L)).thenReturn(Optional.of(products));
        //event
        ResponseMessages<ProductResponseDto> singleProduct = productsServiceImplementation.getProductById(1L);
        //outcome
        assertNotNull(singleProduct);
    }

    @Test
    @DisplayName("Get Product Stored By Id : Negative")
    void GetProductByIdTest_Negative()
    {
        Products products1 = mockProductsData();
        // context
        Mockito.when(productsRepository.findById(anyLong())).thenReturn(Optional.ofNullable(products1));
        //event
        ResponseMessages<ProductResponseDto> singleProduct = productsServiceImplementation.getProductById(anyLong());
        //outcome
        assertNotNull(singleProduct);
    }



    @Test
    @DisplayName("Update Existing Product for Given Id : Positive")
    void UpdateProductTest_Positive()
    {
        Products optionalProducts = mockProductsData();
        Mockito.when(productsRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(optionalProducts));
        // context
        Mockito.when(productsRepository.save(Mockito.any(Products.class))).thenReturn(mockProductsData());
        //event
        ResponseMessages<ProductUpdateDto> existProductUpdate = productsServiceImplementation.updateProduct(Mockito.any(Long.class),mockProductRequestDto());
        //outcome
        assertNotNull(existProductUpdate);
    }

    @Test
    @DisplayName("Update Existing Product for Given Id : Negative")
    void UpdateProductTest_Negative()
    {
        Products optionalProducts = mockProductsData();
        Mockito.when(productsRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(optionalProducts));
        // context
        Mockito.when(productsRepository.save(Mockito.any(Products.class))).thenReturn(null);
        //event
        ResponseMessages<ProductUpdateDto> existProductUpdate = productsServiceImplementation.updateProduct(Mockito.any(Long.class),mockProductRequestDto());
        //outcome
        assertNotEquals(mockProductUpdateDto().getUpdateMessage(),"The product with given id is not updated successfully");
    }

    @Test
    @DisplayName("Delete Existing Product for Given Id : Positive")
    void DeleteProductTest_Positive()
    {
        Products products = mockProductsData();
        // context
        Mockito.when(productsRepository.findById(1L)).thenReturn(Optional.of(products));
        //event
        ResponseMessages<ProductDeleteDto> existProductDelete = productsServiceImplementation.deleteProduct(1L);
        //outcome
        Mockito.verify(productsRepository).deleteById(1L);
    }

    @Test
    @DisplayName("Delete Existing Product for Given Id : Negative")
    void DeleteProductTest_Negative()
    {
        Products products = mockProductsData();
        // context
        Mockito.when(productsRepository.findById(11L)).thenReturn(Optional.of(products));
        //event

        ResponseMessages<ProductDeleteDto> existProductDelete = productsServiceImplementation.deleteProduct(11L);
        //outcome
        Mockito.verify(productsRepository).deleteById(11L);
    }

}

