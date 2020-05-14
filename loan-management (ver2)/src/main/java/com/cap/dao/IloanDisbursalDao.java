package com.cap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cap.entities.LoanDisbursal;



public interface IloanDisbursalDao extends JpaRepository<LoanDisbursal, String> {

	//@Query("SELECT * FROM Loan loanrequest");
}
