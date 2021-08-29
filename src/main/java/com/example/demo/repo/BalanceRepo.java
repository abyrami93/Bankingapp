package com.example.demo.repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Balance;

@Repository
public interface BalanceRepo extends JpaRepository<Balance,Long>{
	
	@Transactional
	@Modifying
	@Query("UPDATE BALANCE s SET s.deposit = ?1 WHERE s.accountid = ?2")
	public void setdeposit(double depositamt,long accountid);
	
	@Query("SELECT s.balanceamount FROM BALANCE s WHERE s.accountid = ?1")
	  double getbalanceamount(long id);
	
	@Transactional
	@Modifying
	@Query("UPDATE BALANCE s SET s.balanceamount = ?1 WHERE s.accountid = ?2")
	public void updatebalance(double newbalance,long accountid);
	
	@Transactional
	@Modifying
	@Query("UPDATE BALANCE s SET s.withdraw = ?1 WHERE s.accountid = ?2")
	public void setrefund(double refundamt,long accountid);
	
	@Transactional
	@Modifying
	@Query("UPDATE BALANCE s SET s.updatedat = CURRENT_TIMESTAMP")
	public void settimestamp();
	
	@Query("SELECT s FROM BALANCE s WHERE s.accountid = ?1 ORDER BY s.updatedat DESC")
	  ArrayList<Balance> viewbalance(long id);

}


