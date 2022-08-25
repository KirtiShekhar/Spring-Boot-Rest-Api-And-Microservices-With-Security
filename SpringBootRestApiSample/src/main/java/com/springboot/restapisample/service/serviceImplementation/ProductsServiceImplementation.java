package com.springboot.restapisample.service.serviceImplementation;

import com.springboot.restapisample.dto.*;
import com.springboot.restapisample.entity.Products;
import com.springboot.restapisample.exception.NameNotFoundException;
import com.springboot.restapisample.exception.ProductNotFoundException;
import com.springboot.restapisample.repository.ProductsRepository;
import com.springboot.restapisample.response.ResponseMessages;
import com.springboot.restapisample.service.ProductsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImplementation implements ProductsService
{
    @Autowired
    ProductsRepository productsRepository;

    @Override
    public ResponseMessages<ProductSaveResponseDto> insertProducts(@Valid ProductRequestDto productRequestDto)
    {
        ResponseMessages<ProductSaveResponseDto> productSaveResponseStatement = new ResponseMessages<>();
        ProductSaveResponseDto productSaveResponseDto = new ProductSaveResponseDto();
        Products productsName = productsRepository.findByProductName(productRequestDto.getProductName());
        if(productsName != null)
        {
            throw new NameNotFoundException("Product with given name already exist , please check....");
        }
        Products products = new Products();
        productRequestDto.setProductManufacturingDate(LocalDateTime.now().toString());
        BeanUtils.copyProperties(productRequestDto,products);
        Products savedProduct = productsRepository.save(products);
        BeanUtils.copyProperties(products,productSaveResponseDto);
        if(savedProduct != null)
        {
            productSaveResponseDto.setSaveMessage("New Product Saved Successfully");
        }
        else
        {
            productSaveResponseDto.setSaveMessage("New Product Not Saved Successfully");
        }
        productSaveResponseStatement.setData(productSaveResponseDto);
        return productSaveResponseStatement;
    }

    @Override
    public ResponseMessages<List<ProductResponseDto>> getAllProducts()
    {
        ResponseMessages<List<ProductResponseDto>> productResponseListAllStatements = new ResponseMessages<>();
        List<ProductResponseDto> productsResponseList = new ArrayList<>();
        Iterator productsIterator = productsRepository.findAll().iterator();
        while(productsIterator.hasNext())
        {
            ProductResponseDto productResponseDto = new ProductResponseDto();
            BeanUtils.copyProperties(productsIterator.next(),productResponseDto);
            productsResponseList.add(productResponseDto);
        }
        productResponseListAllStatements.setData(productsResponseList);
        return productResponseListAllStatements;
    }

    @Override
    public ResponseMessages<ProductResponseDto> getProductById(Long productId)
    {
        ResponseMessages<ProductResponseDto> productResponseStatement = new ResponseMessages<>();
        Products products;
        ProductResponseDto productResponseDto = new ProductResponseDto();
        Optional<Products> existProduct = productsRepository.findById(productId);
        if(existProduct.isPresent())
        {
            products = existProduct.get();
            BeanUtils.copyProperties(products,productResponseDto);
        }
        else
        {
            throw new ProductNotFoundException("Product with given id not exist");
        }
        productResponseStatement.setData(productResponseDto);
        return productResponseStatement;
    }

    @Override
    public ResponseMessages<ProductUpdateDto> updateProduct(Long productId, ProductRequestDto productRequestDto) {
        ResponseMessages<ProductUpdateDto> productUpdateResponseStatement = new ResponseMessages<>();
        ProductUpdateDto productUpdateDto = new ProductUpdateDto();
        Optional<Products> existUpdateProduct = productsRepository.findById(productId);
        if(existUpdateProduct.isPresent())
        {
            Products products = productsRepository.findById(productId).get();
            productRequestDto.setProductManufacturingDate(LocalDateTime.now().toString());
            BeanUtils.copyProperties(productRequestDto,products);
            Products savedProduct = productsRepository.save(products);
            BeanUtils.copyProperties(products,productUpdateDto);
            if(savedProduct != null)
            {
                productUpdateDto.setUpdateMessage("product updated successfully");
            }
            else
            {
                productUpdateDto.setUpdateMessage("product not updated successfully");
            }
        }
        else
        {
            throw new ProductNotFoundException("Product with entered id does not exist , please check");
        }
        productUpdateResponseStatement.setData(productUpdateDto);
        return productUpdateResponseStatement;
    }

    @Override
    public ResponseMessages<ProductDeleteDto> deleteProduct(Long productId)
    {
        ResponseMessages<ProductDeleteDto> productDeleteResponseStatement = new ResponseMessages<>();
        ProductDeleteDto productDeleteDto = new ProductDeleteDto();
        Optional<Products> existProduct = productsRepository.findById(productId);
        if(existProduct.isPresent())
        {
            productsRepository.deleteById(productId);
            productDeleteDto.setDeleteMessage("The product with given id is deleted successfully");
        }
        else
        {
            productDeleteDto.setDeleteMessage("The product with given id is not deleted successfully");
        }
        productDeleteResponseStatement.setData(productDeleteDto);
        return productDeleteResponseStatement;
    }
}
