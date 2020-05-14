package com.cap.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cap.dao.IloanDisbursalDao;
import com.cap.dao.IloanRequestDao;
import com.cap.entities.LoanDisbursal;
import com.cap.entities.LoanRequest;
import com.cap.exceptions.AccountNotFoundException;
@Service
@Transactional
public class LoanDisbursalServiceImp implements ILoanDisbursalService {
	
	@Autowired
	private IloanDisbursalDao dao;
	@Autowired
	private IloanRequestDao daor;
	
	private LoanDisbursal loanDisbursal;
	
	
	public Date getDueDate()
	{
	    Calendar cal = new GregorianCalendar();
	    cal.add(Calendar.DATE, 30);
	    Date dueDate = cal.getTime();
	    return dueDate;
	}
		
	
	LoanDisbursalServiceImp ldsi =new LoanDisbursalServiceImp();
	


	@Override
	public LoanDisbursal findByLoanId(String id) {
		Optional<LoanDisbursal> optional = dao.findById(id);
		if(optional.isPresent())
		{
			LoanDisbursal loanDisbursal = optional.get();
			return loanDisbursal;
		}
		throw new AccountNotFoundException("no such data exist");
	}
	
	
	@Override
	public ArrayList<LoanRequest> retrieveAll() {
	
		return (ArrayList<LoanRequest>) daor.findAll();
	}

	
	
	@Override
	public ArrayList<LoanDisbursal> approveLoan() {
		List<LoanRequest> list = daor.findAll();
		
				
	    
	    for(LoanRequest obj: list)
	    {
	    	if((obj.getCreditScore()>=670))
	    			{
	    		
	    		loanDisbursal.setLoanRequestId(obj.getLoanId());
	    		loanDisbursal.setLoanCustomerId(obj.getAccountId());
	    		loanDisbursal.setLoanAmount(obj.getLoanAmount());    		
	    		loanDisbursal.setLoanTenure(obj.getLoanTenure());
	    		loanDisbursal.setLoan_amount_paid(0);
				loanDisbursal.setLoan_due_date(ldsi.getDueDate());
				
				if(obj.getLoanType().equals("Home"))
				{
					obj.setLoanRoi(8.5);
					loanDisbursal.setLoanType("home");
				}
				else if(obj.getLoanType().equals("Education"))
				{
					obj.setLoanRoi(7.5);
					loanDisbursal.setLoanType("education");
					}
				else if(obj.getLoanType().equals("Personal"))
				{
					obj.setLoanRoi(8.5);
					loanDisbursal.setLoanType("personal");
				}
				else
				{
					obj.setLoanRoi(12.5);
					loanDisbursal.setLoanType("other");
				}
	    	   	double interest = (obj.getLoanAmount()*obj.getloanRoi()*obj.getLoanTenure())/(12*100);
	    		double emi = (obj.getLoanAmount()+interest)/obj.getLoanTenure();
	    		loanDisbursal.setEmi(emi);
	    			    		
	    		obj.setLoanStatus("accepted");
	    		dao.save(loanDisbursal);
	    		
	    	}
	    	  obj.setLoanStatus("rejected");
	    	
	    }
	    	
	    		
	    		return (ArrayList<LoanDisbursal>) dao.findAll();
	    }
	
	

	@Override
	public ArrayList<LoanRequest> rejectedLoanRequests() {
		List<LoanRequest> list = daor.findAll();
		List<LoanRequest> list2 = null;
		
		for(LoanRequest loanRequest: list )
		{
			if(loanRequest.getLoanStatus().equals("rejected"))
			{
				list2.add(loanRequest);				
			}
			
		}
		return (ArrayList<LoanRequest>) list2;
	}
	
	

	@Override
	public ArrayList<LoanDisbursal> approvedLoanList() {
		List<LoanDisbursal> list = dao.findAll();
		
		return (ArrayList<LoanDisbursal>) list;
	}
	
	
	
	@Override
	public String updateLoanAccount(String accountId,Double amount) {
		
		    Optional<LoanDisbursal> optional=dao.findById(accountId);
	        if(optional.isPresent()) {
	            loanDisbursal=optional.get();
	           loanDisbursal.setLoan_amount_paid(loanDisbursal.getLoan_amount_paid()+amount);
	           loanDisbursal.setLoanTenure(loanDisbursal.getLoanTenure()-1);
	            
	            
	        }
		
		
		return "updated";
	}
	


//	@Override
//	public String updateLaonStatus() {
//		
//		return null;
//	}
//
//	@Override
//	public ArrayList<String> updateExistingbalance() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ArrayList<LoanDisbursal> approveLoanWithoutStatus() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//



	

}