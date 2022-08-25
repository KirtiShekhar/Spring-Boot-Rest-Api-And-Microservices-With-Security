package com.springboot.microservices.addressservice.dto;

public class AddressInsertResponseDto
{
    private Long addressId;
    private String state;
    private String city;
    private String street;
    private Long pinCode;
    private String insertMessage;

    public AddressInsertResponseDto() {}

    public AddressInsertResponseDto(Long addressId, String state, String city, String street, Long pinCode, String insertMessage) {
        this.addressId = addressId;
        this.state = state;
        this.city = city;
        this.street = street;
        this.pinCode = pinCode;
        this.insertMessage = insertMessage;
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

    public String getInsertMessage() {
        return insertMessage;
    }

    public void setInsertMessage(String insertMessage) {
        this.insertMessage = insertMessage;
    }
}
