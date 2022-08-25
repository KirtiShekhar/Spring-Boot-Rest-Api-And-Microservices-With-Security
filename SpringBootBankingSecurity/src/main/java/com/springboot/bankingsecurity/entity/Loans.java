package com.springboot.bankingsecurity.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Loans")
public class Loans {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loanNumber")
	private Long loanNumber;
	
	@Column(name = "customerId")
	private Long customerId;
	
	@Column(name="startDt")
	private String startDt;
	
	@Column(name = "loanType")
	private String loanType;
	
	@Column(name = "totalLoan")
	private int totalLoan;
	
	@Column(name = "amountPaid")
	private int amountPaid;
	
	@Column(name = "outstandingAmount")
	private int outstandingAmount;
	
	@Column(name = "createDt")
	private String createDt;

	public Loans() {}

	public Loans(Long loanNumber, Long customerId, String startDt, String loanType, int totalLoan, int amountPaid, int outstandingAmount, String createDt) {
		this.loanNumber = loanNumber;
		this.customerId = customerId;
		this.startDt = startDt;
		this.loanType = loanType;
		this.totalLoan = totalLoan;
		this.amountPaid = amountPaid;
		this.outstandingAmount = outstandingAmount;
		this.createDt = createDt;
	}

	public Long getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(Long loanNumber) {
		this.loanNumber = loanNumber;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getStartDt() {
		return startDt;
	}

	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getTotalLoan() {
		return totalLoan;
	}

	public void setTotalLoan(int totalLoan) {
		this.totalLoan = totalLoan;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(int outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public String getCreateDt() {
		return createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	
}
