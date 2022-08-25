package com.springboot.restapisample.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.restapisample.dto.*;
import com.springboot.restapisample.response.ResponseMessages;
import com.springboot.restapisample.service.ProductsService;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.springboot.restapisample.AppTest;
import com.springboot.restapisample.mockdata.ProductMockData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = AppTest.class)
public class ProductsControllerTest extends ProductMockData
{
    private static final Logger ControllerTestLogger = LoggerFactory.getLogger(ProductsControllerTest.class);

    @Mock
    ProductsService productsService;

    @InjectMocks
    ProductsController productsController;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() throws Exception
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        JacksonTester.initFields(this,objectMapper);
    }

    @Test
    @DisplayName("Save new product : Positive")
    void SaveProductTest_Positive() throws Exception {
        String productRequestString = objectMapper.writeValueAsString(mockProductRequestDto());
        ProductSaveResponseDto productSaveResponseDto = mockProductSaveResponseDto();
        ResponseMessages<ProductSaveResponseDto> productSaveResponse = new ResponseMessages<ProductSaveResponseDto>();
        productSaveResponse.setData(productSaveResponseDto);

        Mockito.lenient().when(productsService.insertProducts(Mockito.any(ProductRequestDto.class))).thenReturn(productSaveResponse);

        ResultActions getProductByIdPositiveResult = this.mockMvc.perform(post("/products/insertProduct")
                        .content(productRequestString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        ControllerTestLogger.error("JSON RESPONSE {}",getProductByIdPositiveResult.andReturn().getResponse().getContentAsString());

        getProductByIdPositiveResult.andExpect(jsonPath("$.messages.messages").isEmpty()).
                andExpect(jsonPath("$.messages.warnings").isEmpty())
                .andExpect(jsonPath("$.messages.errors").isEmpty())
                .andExpect(jsonPath("$.headerMessages.messages").isEmpty())
                .andExpect(jsonPath("$.headerMessages.warnings").isEmpty())
                .andExpect(jsonPath("$.headerMessages.errors").isEmpty())
                .andExpect(jsonPath("$.data").isNotEmpty());
    }

    @Test
    @DisplayName("Save new product : Negative")
    void SaveProductTest_Negative() throws Exception {
        String productRequestString = objectMapper.writeValueAsString(mockProductRequestDto());
        ProductSaveResponseDto productSaveResponseDto = mockProductSaveResponseDto();
        ResponseMessages<ProductSaveResponseDto> productSaveResponse = new ResponseMessages<ProductSaveResponseDto>();
        productSaveResponse.setData(productSaveResponseDto);

        Mockito.lenient().when(productsService.insertProducts(Mockito.any(ProductRequestDto.class))).thenReturn(productSaveResponse);

        ResultActions getProductByIdPositiveResult = this.mockMvc.perform(post("/products/insertProduct")
                        .content(productRequestString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        ControllerTestLogger.error("JSON RESPONSE {}",getProductByIdPositiveResult.andReturn().getResponse().getContentAsString());

        getProductByIdPositiveResult.andExpect(jsonPath("$.messages.messages").isEmpty()).
                andExpect(jsonPath("$.messages.warnings").isEmpty())
                .andExpect(jsonPath("$.messages.errors").isNotEmpty())
                .andExpect(jsonPath("$.headerMessages.messages").isEmpty())
                .andExpect(jsonPath("$.headerMessages.warnings").isEmpty())
                .andExpect(jsonPath("$.headerMessages.errors").isEmpty())
                .andExpect(jsonPath("$.data").isEmpty());
    }

    @Test
    @DisplayName("Get All Products : Positive")
    void GetAllProductTest_Positive() throws Exception {
        List<ProductResponseDto> productResponseListDto = mockProductResponseDtoListData();
        ResponseMessages<List<ProductResponseDto>> productResponseListResponse = new ResponseMessages<List<ProductResponseDto>>();
        productResponseListResponse.setData(productResponseListDto);

        Mockito.lenient().when(productsService.getAllProducts()).thenReturn(productResponseListResponse);

        ResultActions getProductByIdPositiveResult = this.mockMvc.perform(get("/products/getAllProducts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        ControllerTestLogger.error("JSON RESPONSE {}",getProductByIdPositiveResult.andReturn().getResponse().getContentAsString());

        getProductByIdPositiveResult.andExpect(jsonPath("$.messages.messages").isEmpty()).
                andExpect(jsonPath("$.messages.warnings").isEmpty())
                .andExpect(jsonPath("$.messages.errors").isEmpty())
                .andExpect(jsonPath("$.headerMessages.messages").isEmpty())
                .andExpect(jsonPath("$.headerMessages.warnings").isEmpty())
                .andExpect(jsonPath("$.headerMessages.errors").isEmpty())
                .andExpect(jsonPath("$.data").isNotEmpty());
    }

    @Test
    @DisplayName("Get Product Stored By Id : Positive")
    void GetProductByIdTest_Positive() throws Exception {
        ProductResponseDto productResponseDto = mockProductResponseDto();
        ResponseMessages<ProductResponseDto> singleProductResponse = new ResponseMessages<ProductResponseDto>();
        singleProductResponse.setData(productResponseDto);

        Mockito.lenient().when(productsService.getProductById(Mockito.any(Long.class))).thenReturn(singleProductResponse);

        ResultActions getProductByIdPositiveResult = this.mockMvc.perform(get("/products/getProductById/4")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        ControllerTestLogger.error("JSON RESPONSE {}",getProductByIdPositiveResult.andReturn().getResponse().getContentAsString());

        getProductByIdPositiveResult.andExpect(jsonPath("$.messages.messages").isEmpty()).
                andExpect(jsonPath("$.messages.warnings").isEmpty())
                .andExpect(jsonPath("$.messages.errors").isEmpty())
                .andExpect(jsonPath("$.headerMessages.messages").isEmpty())
                .andExpect(jsonPath("$.headerMessages.warnings").isEmpty())
                .andExpect(jsonPath("$.headerMessages.errors").isEmpty())
                .andExpect(jsonPath("$.data").isNotEmpty());
    }

    @Test
    @DisplayName("Get Product Stored By Id : Negative")
    void GetProductByIdTest_Negative() throws Exception {
        ProductResponseDto productResponseDto = mockProductResponseDto();
        ResponseMessages<ProductResponseDto> singleProductResponse = new ResponseMessages<ProductResponseDto>();
        singleProductResponse.setData(productResponseDto);

        Mockito.lenient().when(productsService.getProductById(Mockito.any(Long.class))).thenReturn(singleProductResponse);

        ResultActions getProductByIdPositiveResult = this.mockMvc.perform(get("/products/getProductById/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        ControllerTestLogger.error("JSON RESPONSE {}",getProductByIdPositiveResult.andReturn().getResponse().getContentAsString());

        getProductByIdPositiveResult.andExpect(jsonPath("$.messages.messages").isEmpty()).
                andExpect(jsonPath("$.messages.warnings").isEmpty())
                .andExpect(jsonPath("$.messages.errors").isNotEmpty())
                .andExpect(jsonPath("$.headerMessages.messages").isEmpty())
                .andExpect(jsonPath("$.headerMessages.warnings").isEmpty())
                .andExpect(jsonPath("$.headerMessages.errors").isEmpty())
                .andExpect(jsonPath("$.data").isEmpty());
    }

    @Test
    @DisplayName("Update Product : Positive")
    void UpdateProductTest_Positive() throws Exception {
        String productRequestString = objectMapper.writeValueAsString(mockProductRequestDto());
        ProductUpdateDto productUpdateDto = mockProductUpdateDto();
        ResponseMessages<ProductUpdateDto> updateProductResponse = new ResponseMessages<ProductUpdateDto>();
        updateProductResponse.setData(productUpdateDto);

        Mockito.lenient().when(productsService.updateProduct(Mockito.any(Long.class),Mockito.any(ProductRequestDto.class))).thenReturn(updateProductResponse);

        ResultActions getProductByIdPositiveResult = this.mockMvc.perform(put("/products/updateProduct/4")
                        .content(productRequestString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        ControllerTestLogger.error("JSON RESPONSE {}",getProductByIdPositiveResult.andReturn().getResponse().getContentAsString());

        getProductByIdPositiveResult.andExpect(jsonPath("$.messages.messages").isEmpty()).
                andExpect(jsonPath("$.messages.warnings").isEmpty())
                .andExpect(jsonPath("$.messages.errors").isEmpty())
                .andExpect(jsonPath("$.headerMessages.messages").isEmpty())
                .andExpect(jsonPath("$.headerMessages.warnings").isEmpty())
                .andExpect(jsonPath("$.headerMessages.errors").isEmpty())
                .andExpect(jsonPath("$.data").isNotEmpty());
    }

    @Test
    @DisplayName("Update Product : Negative")
    void UpdateProductTest_Negative() throws Exception {
        String productRequestString = objectMapper.writeValueAsString(mockProductRequestDto());
        ProductUpdateDto productUpdateDto = mockProductUpdateDto();
        ResponseMessages<ProductUpdateDto> updateProductResponse = new ResponseMessages<ProductUpdateDto>();
        updateProductResponse.setData(productUpdateDto);

        Mockito.lenient().when(productsService.updateProduct(Mockito.any(Long.class),Mockito.any(ProductRequestDto.class))).thenReturn(updateProductResponse);

        ResultActions getProductByIdPositiveResult = this.mockMvc.perform(put("/products/updateProduct/3")
                        .content(productRequestString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        ControllerTestLogger.error("JSON RESPONSE {}",getProductByIdPositiveResult.andReturn().getResponse().getContentAsString());

        getProductByIdPositiveResult.andExpect(jsonPath("$.messages.messages").isEmpty()).
                andExpect(jsonPath("$.messages.warnings").isEmpty())
                .andExpect(jsonPath("$.messages.errors").isNotEmpty())
                .andExpect(jsonPath("$.headerMessages.messages").isEmpty())
                .andExpect(jsonPath("$.headerMessages.warnings").isEmpty())
                .andExpect(jsonPath("$.headerMessages.errors").isEmpty())
                .andExpect(jsonPath("$.data").isEmpty());
    }

    @Test
    @DisplayName("Delete Product : Positive")
    void DeleteProductByIdTest_Positive() throws Exception {
        ProductDeleteDto productDeleteDto = mockProductDeleteDto();
        ResponseMessages<ProductDeleteDto> deleteProductResponse = new ResponseMessages<ProductDeleteDto>();
        deleteProductResponse.setData(productDeleteDto);

        Mockito.lenient().when(productsService.deleteProduct(Mockito.any(Long.class))).thenReturn(deleteProductResponse);

        ResultActions getProductByIdPositiveResult = this.mockMvc.perform(delete("/products/delete/14")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        ControllerTestLogger.error("JSON RESPONSE {}",getProductByIdPositiveResult.andReturn().getResponse().getContentAsString());

        getProductByIdPositiveResult.andExpect(jsonPath("$.messages.messages").isEmpty()).
                andExpect(jsonPath("$.messages.warnings").isEmpty())
                .andExpect(jsonPath("$.messages.errors").isEmpty())
                .andExpect(jsonPath("$.headerMessages.messages").isEmpty())
                .andExpect(jsonPath("$.headerMessages.warnings").isEmpty())
                .andExpect(jsonPath("$.headerMessages.errors").isEmpty())
                .andExpect(jsonPath("$.data").isNotEmpty());
    }

    @Test
    @DisplayName("Delete Product : Negative")
    void DeleteProductByIdTest_Negative() throws Exception {
        ProductDeleteDto productDeleteDto = mockProductDeleteDto();
        ResponseMessages<ProductDeleteDto> deleteProductResponse = new ResponseMessages<ProductDeleteDto>();
        deleteProductResponse.setData(productDeleteDto);

        Mockito.lenient().when(productsService.deleteProduct(Mockito.any(Long.class))).thenReturn(deleteProductResponse);

        ResultActions getProductByIdPositiveResult = this.mockMvc.perform(delete("/products/delete/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        ControllerTestLogger.error("JSON RESPONSE {}",getProductByIdPositiveResult.andReturn().getResponse().getContentAsString());

        getProductByIdPositiveResult.andExpect(jsonPath("$.messages.messages").isEmpty()).
                andExpect(jsonPath("$.messages.warnings").isEmpty())
                .andExpect(jsonPath("$.messages.errors").isEmpty())
                .andExpect(jsonPath("$.headerMessages.messages").isEmpty())
                .andExpect(jsonPath("$.headerMessages.warnings").isEmpty())
                .andExpect(jsonPath("$.headerMessages.errors").isEmpty())
                .andExpect(jsonPath("$.data").isNotEmpty());
    }

}