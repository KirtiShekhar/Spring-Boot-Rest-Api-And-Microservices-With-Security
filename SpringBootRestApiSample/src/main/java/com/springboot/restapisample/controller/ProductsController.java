package com.springboot.restapisample.controller;

import com.springboot.restapisample.constants.Constants;
import com.springboot.restapisample.dto.*;
import com.springboot.restapisample.response.ResponseMessages;
import com.springboot.restapisample.service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController
{
    @Autowired
    ProductsService productsService;

    @Autowired
    Environment environment;

    private static final Logger ProductsLogger = LoggerFactory.getLogger(ProductsController.class);

    @GetMapping("/port")
    @Operation(summary = "Displaying the port Application Running On")
    public String getPortInfo()
    {
        ProductsLogger.info("Displaying the port Application Running On");
        String port = environment.getProperty("local.server.port");
        ProductsLogger.info("Application running on port : "+ port);
        return "Application running on port : "+ port;
    }

    @PostMapping("/insertProduct")
    @Operation(summary = "insert new product in the database")
    public ResponseEntity<ResponseMessages<ProductSaveResponseDto>> insertProduct(@RequestBody ProductRequestDto productRequestDto)
    {
        ProductsLogger.info("Inserting new product to database");
        ResponseMessages<ProductSaveResponseDto> productSaveResponseStatement = new ResponseMessages<>();
        HttpStatus productSaveResponseStatus = HttpStatus.OK;
        try
        {
            ProductsLogger.info("invoking productsService.insertProducts(productRequestDto) service");
            productSaveResponseStatement = productsService.insertProducts(productRequestDto);
            productSaveResponseStatus = HttpStatus.CREATED;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            ProductsLogger.error("Error in insert product : ",errorMessage);
            productSaveResponseStatement.getMessages().addError(errorMessage);
            productSaveResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(productSaveResponseStatus).body(productSaveResponseStatement);
    }

    @GetMapping(value = "/getAllProducts",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All Products Stored in database")
    public ResponseEntity<ResponseMessages<List<ProductResponseDto>>> getAllProducts()
    {
        ProductsLogger.info("Get All Products Stored in database");
        ResponseMessages<List<ProductResponseDto>> productResponseListResponseEntityStatement = new ResponseMessages<>();
        HttpStatus productListResponseStatus = HttpStatus.OK;
        try
        {
            ProductsLogger.info("invoking productsService.getAllProducts() service");
            productResponseListResponseEntityStatement = productsService.getAllProducts();
            productListResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            ProductsLogger.error("Error in get all products : ",errorMessage);
            productResponseListResponseEntityStatement.getMessages().addError(errorMessage);
            productListResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(productListResponseStatus).body(productResponseListResponseEntityStatement);
    }

    @GetMapping(value = "/getProductById/{productId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get Product For given Id Stored in database")
    public ResponseEntity<ResponseMessages<ProductResponseDto>> getProduct(@PathVariable Long productId)
    {
        ProductsLogger.info("Get Product For given Id Stored in database");
        ResponseMessages<ProductResponseDto> productResponseSingleResponse = new ResponseMessages<>();
        HttpStatus productResponseSingleResponseStatus = HttpStatus.OK;
        try
        {
            ProductsLogger.info("invoking productsService.getProductById(productId) service");
            productResponseSingleResponse = productsService.getProductById(productId);
            productResponseSingleResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            ProductsLogger.error("Error in get single product : ",errorMessage);
            productResponseSingleResponse.getMessages().addError(errorMessage);
            productResponseSingleResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(productResponseSingleResponseStatus).body(productResponseSingleResponse);
    }

    @PutMapping("/updateProduct/{productId}")
    @Operation(summary = "Update Existing Products Stored in database")
    public ResponseEntity<ResponseMessages<ProductUpdateDto>> updateProducts(@PathVariable Long productId,@RequestBody ProductRequestDto productRequestDto)
    {
        ProductsLogger.info("Update Existing Products Stored in database");
        ResponseMessages<ProductUpdateDto> productUpdateResponse = new ResponseMessages<>();
        HttpStatus productUpdateResponseResponseStatus = HttpStatus.OK;
        try
        {
            ProductsLogger.info("invoking productsService.updateProduct(productId,productRequestDto) service");
            productUpdateResponse = productsService.updateProduct(productId,productRequestDto);
            productUpdateResponseResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            ProductsLogger.error("Error in update product : ",errorMessage);
            productUpdateResponse.getMessages().addError(errorMessage);
            productUpdateResponseResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(productUpdateResponseResponseStatus).body(productUpdateResponse);
    }

    @DeleteMapping("/delete/{productId}")
    @Operation(summary = "Delete Existing Products from database")
    public ResponseEntity<ResponseMessages<ProductDeleteDto>> deleteProduct(@PathVariable Long productId)
    {
        ProductsLogger.info("Delete Existing Products from database");
        ResponseMessages<ProductDeleteDto> productDeleteResponse = new ResponseMessages<>();
        HttpStatus productDeleteResponseStatus = HttpStatus.OK;
        try
        {
            ProductsLogger.info("invoking productsService.deleteProduct(productId) service");
            productDeleteResponse = productsService.deleteProduct(productId);
            productDeleteResponseStatus = HttpStatus.OK;
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? Constants.UNEXPECTED_ERROR : ex.getMessage();
            ProductsLogger.error("Error in delete products : ",errorMessage);
            productDeleteResponse.getMessages().addError(errorMessage);
            productDeleteResponseStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(productDeleteResponseStatus).body(productDeleteResponse);
    }
}
