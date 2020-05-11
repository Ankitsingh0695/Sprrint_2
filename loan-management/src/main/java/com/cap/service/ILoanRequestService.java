package com.cap.service;

import com.cap.entities.LoanRequest;

public interface ILoanRequestService {

	LoanRequest findById(String accountId);
	LoanRequest save(LoanRequest loanRequest);
	
}
