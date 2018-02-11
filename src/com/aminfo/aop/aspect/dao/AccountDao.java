package com.aminfo.aop.aspect.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aminfo.aop.aspect.model.Account;

@Component
public class AccountDao {

	public void addAccount(String accNo, Integer id) {
		System.out.println(getClass().getName() + " adding account number in banck: " + accNo +"\n");
	}
	
	public void getAccountDetails() {
		System.out.println("get Account Details.");
	}
	
	public void setAccountDetails() {
		System.out.println("get Account Details.");
	}
	
	public List<Account> findAllAccount() {
		System.out.println("going to get all Accounts.");
		List<Account> accounts = new ArrayList<>();
		Account a1 = new Account(123564, "Abhi", true);
		Account a2 = new Account(123564, "Abhi", true);
		Account a3 = new Account(123564, "Abhi", true);
		Account a4 = new Account(123564, "Abhi", true);
		
		accounts.add(a1);
		accounts.add(a2);
		accounts.add(a3);
		accounts.add(a4);
		System.out.println("Account Size List: "+accounts.size());
		return accounts;
	}
	
	public Boolean validateAccount(Integer accNo) throws Exception {
		System.out.println("inside validate Account method.");
		if(accNo < 10) {
			throw new Exception("invalid Account number found should be gratter then 10.");
		}
		
		return true;
	}
}
