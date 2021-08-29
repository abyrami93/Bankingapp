package com.example.demo.service;

import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.model.AccountResponse;
import com.example.demo.model.Accountdetails;
import com.example.demo.model.Balance;
import com.example.demo.repo.AccountRepo;
import com.example.demo.repo.BalanceRepo;

@Service
public class AccountService {

	@Autowired
	private AccountRepo accrepo;

	@Autowired
	private BalanceRepo balancerepo;

	// private static final double MAX_DEPOSIT_PER_DAY = 15000;

	public AccountResponse save(Account account) {

		final Account AccountArr[] = { account };
		// final Balance BalanceArr[] = { balance };

		if (account != null) {

			AccountArr[0].setCreatedat(new Timestamp(System.currentTimeMillis()));
		}

		if (!(AccountArr[0].getFirstname().isEmpty()) && !(AccountArr[0].getLastname().isEmpty())) {
			accrepo.save(account);
			Balance balance = new Balance();
			balance.setBalanceamount(500.0);
			balance.setAccountid(account.getId());
			balance.setCreatedat(new Timestamp(System.currentTimeMillis()));
			balancerepo.save(balance);
			return new AccountResponse("200", "success");

		} else
			return new AccountResponse("500", "failure");

	}

	public List<Account> getaccountdetails() {

		List<Account> accdetails = accrepo.findbyid();
		// System.out.println("accdetails"+accdetails);
		// TODO Auto-generated method stub
		return accdetails;
	}

	public ArrayList<Account> getaccountusername(long id) {

		ArrayList<Account> accdetails = accrepo.findbyid(id);
		// System.out.println("accdetails"+accdetails);
		// TODO Auto-generated method stub
		return accdetails;
	}

	public double addbalance(Balance balance) {

		long accountid = balance.getAccountid();
		double depositamt = balance.getDeposit();
		balancerepo.setdeposit(depositamt, accountid);
		System.out.println("Depo" + depositamt);
		double oldbalance = balancerepo.getbalanceamount(accountid);
		System.out.println("oldbalance" + oldbalance);
		double newbalance = 0.0;
		if (oldbalance == 500.0 || oldbalance > 500.0) {

			newbalance = oldbalance + balance.getDeposit();

			balancerepo.updatebalance(newbalance, accountid);

		
			balancerepo.settimestamp();
			

		} else {
			System.out.println("insufficient balance");
		}
		return newbalance;

	}

	
	  
	 
	  public double withdraw(Balance balance) {
	  
	  long accountid = balance.getAccountid(); 
	  double refundamt = balance.getWithdraw(); 
	  balancerepo.setrefund(refundamt,accountid);
	  System.out.println("Depo"+refundamt); double oldbalance =
	 balancerepo.getbalanceamount(accountid);
	  System.out.println("oldbalance"+oldbalance); double newbalance = 0.0;
	  if(oldbalance == 500.0 || oldbalance > 500.0) {
	  
	  newbalance = oldbalance - balance.getWithdraw();
	  
	  
	  balancerepo.updatebalance(newbalance,accountid);
		balancerepo.settimestamp();
	  
	  
	  }
		 
	 
	 else 
	 {
		 System.out.println("minimum balance should be 500"); 
	 }
	  return newbalance;
	
	 
}

	public List<Balance> viewbalance() {
		long accountid = 0;
		for(Balance bal : balancerepo.findAll())
			 accountid = bal.getAccountid();
		
		ArrayList<Balance> viewbal = balancerepo.viewbalance(accountid);
		System.out.println("viewbal"+viewbal);
		
		return viewbal;
		
		
		
	}
}
