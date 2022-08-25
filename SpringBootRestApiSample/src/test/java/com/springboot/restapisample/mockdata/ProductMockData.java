package com.springboot.restapisample.mockdata;

import com.springboot.restapisample.dto.*;
import com.springboot.restapisample.entity.Products;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductMockData
{
    public ProductMockData(){}

    protected Products mockProductsData()
    {
        Products mockProducts = new Products();
        mockProducts.setProductName("HP Laptop");
        mockProducts.setProductDescription("Gaming Laptop Pavillion");
        mockProducts.setProductPrice(44400.00);
        mockProducts.setProductQuantity(2);
        mockProducts.setProductManufacturingDate(LocalDateTime.now().toString());
        return mockProducts;
    }

    protected List<ProductResponseDto> mockProductResponseDtoListData()
    {
        List<ProductResponseDto> productResponseList = new ArrayList<>();
        ProductResponseDto products1 = new ProductResponseDto();
        ProductResponseDto products2 = new ProductResponseDto();
        products1.setProductId(3L);
        products2.setProductId(4L);
        products1.setProductName("Boat Speaker");
        products1.setProductDescription("Good Bluetooth Connectivity and sound output");
        products2.setProductDescription("Tv with wifi connectivity and good graphics");
        products1.setProductPrice(2500.00);
        products2.setProductPrice(45000.00);
        products1.setProductQuantity(4);
        products2.setProductQuantity(8);
        products1.setProductManufacturingDate(LocalDateTime.now().toString());
        products2.setProductManufacturingDate(LocalDateTime.now().toString());
        productResponseList.add(products1);
        productResponseList.add(products2);
        return  productResponseList;
    }

    protected List<ProductResponseDto> mockProductResponseDtoListEmptyData()
    {
        List<ProductResponseDto> productResponseEmptyList = new ArrayList<>();
        return  productResponseEmptyList;
    }

    protected List<Products> mockProductResponseListPositiveData()
    {
        List<Products> productResponseList = new ArrayList<>();
        Products products1 = new Products();
        Products products2 = new Products();
        products1.setProductId(3L);
        products2.setProductId(4L);
        products1.setProductName("Boat Speaker");
        products1.setProductDescription("Good Bluetooth Connectivity and sound output");
        products2.setProductDescription("Tv with wifi connectivity and good graphics");
        products1.setProductPrice(2500.00);
        products2.setProductPrice(45000.00);
        products1.setProductQuantity(4);
        products2.setProductQuantity(8);
        products1.setProductManufacturingDate(LocalDateTime.now().toString());
        products2.setProductManufacturingDate(LocalDateTime.now().toString());
        productResponseList.add(products1);
        productResponseList.add(products2);
        return  productResponseList;
    }

    protected List<Products> mockProductResponseListNegativeData()
    {
        List<Products> productResponseList = new ArrayList<>();
        Products products1 = new Products();
        products1.setProductId(3L);
        products1.setProductName("Boat Speaker");
        products1.setProductDescription("Good Bluetooth Connectivity and sound output");
        products1.setProductPrice(2500.00);
        products1.setProductQuantity(4);
        products1.setProductManufacturingDate(LocalDateTime.now().toString());
        productResponseList.add(products1);
        return  productResponseList;
    }

    protected ProductRequestDto mockProductRequestDto()
    {
        ProductRequestDto mockProductRequestDto = new ProductRequestDto();
        mockProductRequestDto.setProductName("Kingston Biometrics with sensor");
        mockProductRequestDto.setProductDescription("Used to capture fingerprints for attendance in organizations and also at in and out");
        mockProductRequestDto.setProductPrice(44400.00);
        mockProductRequestDto.setProductQuantity(2);
        mockProductRequestDto.setProductManufacturingDate(LocalDateTime.now().toString());
        return mockProductRequestDto;
    }

    protected ProductResponseDto mockProductResponseDto()
    {
        ProductResponseDto mockProductResponseDto = new ProductResponseDto();
        mockProductResponseDto.setProductId(2L);
        mockProductResponseDto.setProductName("Samsung Galaxy S9");
        mockProductResponseDto.setProductDescription("Very Awesome Mobile set with good features");
        mockProductResponseDto.setProductPrice(63000.00);
        mockProductResponseDto.setProductQuantity(2);
        mockProductResponseDto.setProductManufacturingDate(LocalDateTime.now().toString());
        return mockProductResponseDto;
    }

    protected ProductSaveResponseDto mockProductSaveResponseDto()
    {
        ProductSaveResponseDto mockProductSaveResponseDto = new ProductSaveResponseDto();
        mockProductSaveResponseDto.setProductId(2L);
        mockProductSaveResponseDto.setProductDescription("Gaming Laptop Pavillion");
        mockProductSaveResponseDto.setProductPrice(44410.00);
        mockProductSaveResponseDto.setProductQuantity(3);
        mockProductSaveResponseDto.setProductManufacturingDate(LocalDateTime.now().toString());
        mockProductSaveResponseDto.setProductName("Hp Laptop with Accessories");
        mockProductSaveResponseDto.setSaveMessage("The new product saved successfully");
        return mockProductSaveResponseDto;
    }

    protected ProductUpdateDto mockProductUpdateDto()
    {
        ProductUpdateDto mockProductUpdateDto = new ProductUpdateDto();
        mockProductUpdateDto.setProductId(1L);
        mockProductUpdateDto.setProductDescription("Gaming Laptop Pavillion");
        mockProductUpdateDto.setProductPrice(44410.00);
        mockProductUpdateDto.setProductQuantity(3);
        mockProductUpdateDto.setProductManufacturingDate(LocalDateTime.now().toString());
        mockProductUpdateDto.setProductName("Hp Laptop with Accessories");
        mockProductUpdateDto.setUpdateMessage("The product with given id is updated successfully");
        return mockProductUpdateDto;
    }

    protected ProductDeleteDto mockProductDeleteDto()
    {
        ProductDeleteDto mockProductDeleteDto = new ProductDeleteDto();
        mockProductDeleteDto.setDeleteMessage("The product with given id deleted successfully");
        return mockProductDeleteDto;
    }
}
