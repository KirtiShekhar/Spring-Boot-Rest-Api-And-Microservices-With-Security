package com.springboot.microservices.addressservice.dto;

import javax.validation.constraints.NotNull;

public class AddressRequestDto
{
    @NotNull(message = "state Should not be Empty or blank")
    private String state;
    @NotNull(message = "city Should not be Empty or blank")
    private String city;
    @NotNull(message = "street Should not be Empty or blank")
    private String street;
    @NotNull(message = "pinCode Should not be Empty or blank")
    private Long pinCode;

    public AddressRequestDto() {}

    public AddressRequestDto(String state, String city, String street, Long pinCode) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getPinCode() {
        return pinCode;
    }

    public void setPinCode(Long pinCode) {
        this.pinCode = pinCode;
    }
}
