package com.springboot.microservices.addressservice.dto;

public class AddressResponseDto
{
    private Long addressId;
    private String state;
    private String city;
    private String street;
    private Long pinCode;

    public AddressResponseDto() {}

    public AddressResponseDto(Long addressId, String state, String city, String street, Long pinCode) {
        this.addressId = addressId;
        this.state = state;
        this.city = city;
        this.street = street;
        this.pinCode = pinCode;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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
