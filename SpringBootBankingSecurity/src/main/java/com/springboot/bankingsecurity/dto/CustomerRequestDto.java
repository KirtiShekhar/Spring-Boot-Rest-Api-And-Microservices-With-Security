package com.springboot.bankingsecurity.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustomerRequestDto
{
    private String customerFullName;
    private String customerEmailAddress;
    @JsonIgnore
    private String customerPassword;
    private String customerRole;
    private String customerContactNumber;

    public CustomerRequestDto() {}

    public CustomerRequestDto(String customerFullName, String customerEmailAddress, String customerPassword, String customerRole, String customerContactNumber) {
        this.customerFullName = customerFullName;
        this.customerEmailAddress = customerEmailAddress;
        this.customerPassword = customerPassword;
        this.customerRole = customerRole;
        this.customerContactNumber = customerContactNumber;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerRole() {
        return customerRole;
    }

    public void setCustomerRole(String customerRole) {
        this.customerRole = customerRole;
    }

    public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    public void setCustomerContactNumber(String customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }
}
