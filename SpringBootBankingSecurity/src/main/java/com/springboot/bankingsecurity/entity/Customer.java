package com.springboot.bankingsecurity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Customer")
public class Customer
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Long customerId;
    @Column(name = "customerFullName")
    private String customerFullName;
    @Column(name = "customerEmailAddress")
    private String customerEmailAddress;

    @JsonIgnore
    @Column(name = "customerPassword")
    private String customerPassword;
    @Column(name = "customerRole")
    private String customerRole;
    @Column(name = "customerContactNumber")
    private String customerContactNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "customer",fetch= FetchType.EAGER)
    private Set<Authority> authorities;

    public Customer() {}

    public Customer(Long customerId, String customerFullName, String customerEmailAddress, String customerPassword, String customerRole, String customerContactNumber, Set<Authority> authorities) {
        this.customerId = customerId;
        this.customerFullName = customerFullName;
        this.customerEmailAddress = customerEmailAddress;
        this.customerPassword = customerPassword;
        this.customerRole = customerRole;
        this.customerContactNumber = customerContactNumber;
        this.authorities = authorities;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}
