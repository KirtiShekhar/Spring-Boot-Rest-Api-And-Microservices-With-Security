package com.springboot.bankingsecurity.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class AccountsRequestDto
{
    private Long customerId;
    private String accountType;
    private String branchAddress;
    @JsonIgnore
    private String createDt;

    public AccountsRequestDto() {}

    public AccountsRequestDto(Long customerId, String accountType, String branchAddress, String createDt) {
        this.customerId = customerId;
        this.accountType = accountType;
        this.branchAddress = branchAddress;
        this.createDt = createDt;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }
}
