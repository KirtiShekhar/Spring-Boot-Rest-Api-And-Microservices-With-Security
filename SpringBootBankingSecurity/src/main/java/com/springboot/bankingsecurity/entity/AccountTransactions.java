package com.springboot.bankingsecurity.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AccountTransactions")
public class AccountTransactions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transactionId")
	private Long transactionId;
	
	@Column(name="accountNumber")
	private long accountNumber;
	
	@Column(name = "customerId")
	private Long customerId;
	
	@Column(name="transactionDt")
	private String transactionDt;
	
	@Column(name = "transactionSummary")
	private String transactionSummary;
	
	@Column(name="transactionType")
	private String transactionType;
	
	@Column(name = "transactionAmt")
	private int transactionAmt;
	
	@Column(name = "closingBalance")
	private int closingBalance;
	
	@Column(name = "createDt")
	private String createDt;

	public AccountTransactions() {}

	public AccountTransactions(Long transactionId, long accountNumber, Long customerId, String transactionDt, String transactionSummary, String transactionType, int transactionAmt, int closingBalance, String createDt) {
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.customerId = customerId;
		this.transactionDt = transactionDt;
		this.transactionSummary = transactionSummary;
		this.transactionType = transactionType;
		this.transactionAmt = transactionAmt;
		this.closingBalance = closingBalance;
		this.createDt = createDt;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getTransactionDt() {
		return transactionDt;
	}

	public void setTransactionDt(String transactionDt) {
		this.transactionDt = transactionDt;
	}

	public String getTransactionSummary() {
		return transactionSummary;
	}

	public void setTransactionSummary(String transactionSummary) {
		this.transactionSummary = transactionSummary;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getTransactionAmt() {
		return transactionAmt;
	}

	public void setTransactionAmt(int transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	public int getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(int closingBalance) {
		this.closingBalance = closingBalance;
	}

	public String getCreateDt() {
		return createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
}
