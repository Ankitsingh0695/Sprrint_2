package com.cap.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.entities.LoanRequest;

public interface IloanRequestDao extends JpaRepository<LoanRequest, String>{

}
