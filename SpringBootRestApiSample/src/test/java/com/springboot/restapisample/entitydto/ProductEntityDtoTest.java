package com.springboot.restapisample.entitydto;

import com.springboot.restapisample.AppTest;
import com.springboot.restapisample.dto.ProductDeleteDto;
import com.springboot.restapisample.dto.ProductRequestDto;
import com.springboot.restapisample.dto.ProductResponseDto;
import com.springboot.restapisample.dto.ProductUpdateDto;
import com.springboot.restapisample.entity.Products;
import com.springboot.restapisample.mockdata.ProductMockData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = AppTest.class)
public class ProductEntityDtoTest extends ProductMockData
{
    @BeforeEach
    void setUp(){}

    @Test
    @DisplayName("Product Entity : Positive")
    void ProductEntityPositiveTest()
    {
        Products productEntity = mockProductsData();
        assertEquals(productEntity.getProductName(),"HP Laptop");
        assertEquals(productEntity.getProductDescription(),"Gaming Laptop Pavillion");
        assertEquals(productEntity.getProductPrice(),44400.00);
        assertEquals(productEntity.getProductQuantity(),2);
        assertEquals(productEntity.getProductManufacturingDate(),LocalDateTime.now().toString());
    }

    @Test
    @DisplayName("Product Entity : Negative")
    void ProductEntityNegativeTest()
    {
        Products productEntity = mockProductsData();
        assertNotEquals(productEntity.getProductName(),"Dell Laptop");
        assertNotEquals(productEntity.getProductDescription(),"Normal Laptop");
        assertNotEquals(productEntity.getProductPrice(),2700.00);
        assertNotEquals(productEntity.getProductQuantity(),1);
        assertNotEquals(productEntity.getProductManufacturingDate(),"LocalDateTime.now().toString()");
    }

    @Test
    @DisplayName("Product Request Dto : Positive")
    void ProductRequestDtoPositiveTest()
    {
        ProductRequestDto productRequestDto = mockProductRequestDto();
        assertEquals(productRequestDto.getProductName(),"HP Laptop");
        assertEquals(productRequestDto.getProductDescription(),"Gaming Laptop Pavillion");
        assertEquals(productRequestDto.getProductPrice(),44400.00);
        assertEquals(productRequestDto.getProductQuantity(),2);
        assertEquals(productRequestDto.getProductManufacturingDate(),LocalDateTime.now().toString());
    }

    @Test
    @DisplayName("Product Request Dto : Negative")
    void ProductRequestDtoNegativeTest()
    {
        ProductRequestDto productRequestDto = mockProductRequestDto();
        assertNotEquals(productRequestDto.getProductName(),"Dell Laptop with Accessories");
        assertNotEquals(productRequestDto.getProductDescription(),"Normal Laptop");
        assertNotEquals(productRequestDto.getProductPrice(),2700.00);
        assertNotEquals(productRequestDto.getProductQuantity(),1);
        assertNotEquals(productRequestDto.getProductManufacturingDate(),"LocalDateTime.now().toString()");
    }

    @Test
    @DisplayName("Product Response Dto : Positive")
    void ProductResponseDtoPositiveTest()
    {
        ProductResponseDto productResponseDto = mockProductResponseDto();
        assertEquals(productResponseDto.getProductId(),2L);
        assertEquals(productResponseDto.getProductName(),"Samsung Galaxy S9");
        assertEquals(productResponseDto.getProductDescription(),"Very Awesome Mobile set with good features");
        assertEquals(productResponseDto.getProductPrice(),63000.00);
        assertEquals(productResponseDto.getProductQuantity(),2);
        assertEquals(productResponseDto.getProductManufacturingDate(),LocalDateTime.now().toString());
    }

    @Test
    @DisplayName("Product Response Dto : Negative")
    void ProductResponseDtoNegativeTest()
    {
        ProductResponseDto productResponseDto = mockProductResponseDto();
        assertNotEquals(productResponseDto.getProductId(),9L);
        assertNotEquals(productResponseDto.getProductName(),"Dell Laptop with Accessories");
        assertNotEquals(productResponseDto.getProductDescription(),"Normal Laptop");
        assertNotEquals(productResponseDto.getProductPrice(),2700.00);
        assertNotEquals(productResponseDto.getProductQuantity(),1);
        assertNotEquals(productResponseDto.getProductManufacturingDate(),"LocalDateTime.now().toString()");
    }

    @Test
    @DisplayName("Product Update Dto : Positive")
    void ProductUpdateDtoPositiveTest()
    {
        ProductUpdateDto productUpdateDto = mockProductUpdateDto();
        assertEquals(productUpdateDto.getProductId(),1L);
        assertEquals(productUpdateDto.getProductName(),"Hp Laptop with Accessories");
        assertEquals(productUpdateDto.getProductDescription(),"Gaming Laptop Pavillion");
        assertEquals(productUpdateDto.getProductPrice(),44410.00);
        assertEquals(productUpdateDto.getProductQuantity(),3);
        assertEquals(productUpdateDto.getProductManufacturingDate(),LocalDateTime.now().toString());
        assertEquals(productUpdateDto.getUpdateMessage(),"The product with given id is updated successfully");
    }

    @Test
    @DisplayName("Product Update Dto : Negative")
    void ProductUpdateDtoNegativeTest()
    {
        ProductUpdateDto productUpdateDto = mockProductUpdateDto();
        assertNotEquals(productUpdateDto.getProductId(),9L);
        assertNotEquals(productUpdateDto.getProductName(),"Dell Laptop with Accessories");
        assertNotEquals(productUpdateDto.getProductDescription(),"Normal Laptop");
        assertNotEquals(productUpdateDto.getProductPrice(),2700.00);
        assertNotEquals(productUpdateDto.getProductQuantity(),1);
        assertNotEquals(productUpdateDto.getProductManufacturingDate(),"LocalDateTime.now().toString()");
        assertNotEquals(productUpdateDto.getUpdateMessage(),"The product with given id is not updated successfully");
    }

    @Test
    @DisplayName("Product Delete Dto : Positive")
    void ProductDeleteDtoPositiveTest()
    {
        ProductDeleteDto productDeleteDto = mockProductDeleteDto();
        assertEquals(productDeleteDto.getDeleteMessage(),"The product with given id deleted successfully");
    }

    @Test
    @DisplayName("Product Delete Dto : Negative")
    void ProductDeleteDtoNegativeTest()
    {
        ProductDeleteDto productDeleteDto = mockProductDeleteDto();
        assertNotEquals(productDeleteDto.getDeleteMessage(),"The product with given id not deleted successfully");
    }

}