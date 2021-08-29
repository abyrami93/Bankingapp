package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "BALANCE")
@Table(name="Balance")
public class Balance {

	@Id
	
	private long accountid;
	
	
	private double deposit;
	private double withdraw;
	private double balanceamount;
	
	private Timestamp createdat;
	
	private Timestamp updatedat;

	
	
	public double getDeposit() {
		return deposit;
	}



	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}



	public double getWithdraw() {
		return withdraw;
	}



	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}



	public long getAccountid() {
		return accountid;
	}



	public void setAccountid(long accountid) {
		this.accountid = accountid;
	}

	public double getBalanceamount() {
		return balanceamount;
	}

	public void setBalanceamount(double balanceamount) {
		this.balanceamount = balanceamount;
	}

	public Timestamp getCreatedat() {
		return createdat;
	}

	

	public Balance(long accountid, double deposit, double withdraw, double balanceamount, Timestamp createdat,
			Timestamp updatedat) {
		super();
		this.accountid = accountid;
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.balanceamount = balanceamount;
		this.createdat = createdat;
		this.updatedat = updatedat;
	}



	public void setCreatedat(Timestamp createdat) {
		this.createdat = createdat;
	}

	public Timestamp getUpdatedat() {
		return updatedat;
	}

	public void setUpdatedat(Timestamp updatedat) {
		this.updatedat = updatedat;
	}

	
	public Balance() {
	
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "Balance [accountid=" + accountid + ", deposit=" + deposit + ", withdraw=" + withdraw
				+ ", balanceamount=" + balanceamount + ", createdat=" + createdat + ", updatedat=" + updatedat + "]";
	}
	
	
}
