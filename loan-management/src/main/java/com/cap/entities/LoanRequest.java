package com.cap.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;


@Entity
@Table(name= "loanrequest")
public class LoanRequest {

	@Id
	@NotNull
	@Column(length=12)
	private String loanId;
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public Double getLoanRoi() {
		return loanRoi;
	}
	public void setLoanRoi(Double loanRoi) {
		this.loanRoi = loanRoi;
	}

	private String accountId;
	
	@NotNull
	@Size(min=1000, max=100000)
	private Double loanAmount;
	
	private String loanType;
	
	@NotNull
	@Size(min=12, max=240)
	private int loanTenure;
	
	@NotNull
	@Size(min=1, max=10)
	private Double loanRoi=8.0d;
	
	private String loanStatus="pending";
	
	@NotNull
	@Size(min=100, max=999)
	private int creditScore;
	
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public int getLoanTenure() {
		return loanTenure;
	}
	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}
	public Double getloanRoi() {
		return loanRoi;
	}
	public void setRoi(Double loanRoi) {
		this.loanRoi = loanRoi;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	
	
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        LoanRequest customer = (LoanRequest) o;
	        return accountId == customer.accountId;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(accountId);
	    }
	
	
}
