package com.cap.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.entities.LoanDisbursal;



public interface IloanDisbursalDao extends JpaRepository<LoanDisbursal, String> {

}
