package com.example.demo.controller;



import java.util.Arrays;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;
import com.example.demo.model.AccountResponse;
import com.example.demo.model.Accountdetails;
import com.example.demo.model.Balance;
import com.example.demo.repo.AccountRepo;
import com.example.demo.service.AccountService;

@RestController

public class AccountController {
	
	@Autowired private AccountService accountservice;
//Save the data - Account details in the database 
   
	@PostMapping(value = "/create",produces = MediaType.APPLICATION_JSON_VALUE)
		
public ResponseEntity<?> saveOrder(@RequestBody Account account) throws Exception{
		
		AccountResponse accountresponse = null;
		accountresponse = accountservice.save(account);
	       return ResponseEntity.ok(accountresponse);
		
}
	
	@GetMapping(value = "/getaccountdetails")
//Get all the data's from the database	
public ResponseEntity<?> getaccountdetails() throws Exception {
		
	return ResponseEntity.ok(accountservice.getaccountdetails());
	
		
	}
	
  @GetMapping(value = "/getaccountusername/{id}")

//Get the data from the database based on the id	
public ResponseEntity<?> getaccountusername(@PathVariable long id) throws Exception {
	
	
		return ResponseEntity.ok(accountservice.getaccountusername(id));
		
}

@PostMapping(value = "/deposit",produces = MediaType.APPLICATION_JSON_VALUE)

//Deposit amount in the balance table in the database
public ResponseEntity<?> deposit(@RequestBody Balance balance) throws Exception{
	
return ResponseEntity.ok(accountservice.addbalance(balance));
	
	
}

@PostMapping(value = "/withdraw",produces = MediaType.APPLICATION_JSON_VALUE)
  //Withdraw amount in the balance table in the database 
  
  public ResponseEntity<?> withdraw(@RequestBody Balance balance) throws Exception{
  
  return ResponseEntity.ok(accountservice.withdraw(balance));
 }
 
 @GetMapping(value = "/viewbalance/{accountid}")
//Get the transaction details
 
 public ResponseEntity<?> viewbalance(@PathVariable long accountid) throws Exception{
	  
	  return ResponseEntity.ok(accountservice.viewbalance());
	 }

}
