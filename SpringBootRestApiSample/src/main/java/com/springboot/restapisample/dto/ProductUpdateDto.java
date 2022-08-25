package com.springboot.restapisample.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductUpdateDto
{
    @NotNull(message = "product Id Should not be Empty or blank")
    private Long productId;
    @NotNull(message = "product Name Should not be Empty or blank")
    private String productName;
    @NotNull(message = "product Name Should not be Empty or blank")
    private String productDescription;
    @NotNull(message = "product Price Should not be Empty or blank")
    private Double productPrice;
    @NotNull(message = "product Quantity Should not be Empty or blank")
    private Integer productQuantity;
    @NotNull(message = "product Manufacturing Date Should not be Empty or blank")
    @JsonIgnore
    private String productManufacturingDate;
    private String updateMessage;
}
