package com.springboot.bankingsecurity.entity;

import javax.persistence.*;

@Entity
@Table(name = "Accounts")
public class Accounts
{
	@Column(name = "customerId")
	private Long customerId;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="accountNumber")
	private Long accountNumber;
	@Column(name="accountType")
	private String accountType;
	@Column(name = "branchAddress")
	private String branchAddress;
	@Column(name = "createDt")
	private String createDt;

	public Accounts() {}

	public Accounts(Long customerId, Long accountNumber, String accountType, String branchAddress, String createDt) {
		this.customerId = customerId;
		this.accountNumber = accountNumber;
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
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
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
