
package com.aminfo.aop.around.aspect.service;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.aminfo.aop.aspect.model.Account;

@Component
public class AccountService {
	
	Logger logger = Logger.getLogger(getClass().getName());
	
	public String validateAccount(Account acc) {
		
		try {
			logger.info("--inside method validate Account");
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "Account Opened";
	}

	public String validateAccount(Account acc, boolean isVip) {
		
		logger.info("Validating VIP Users");
		if(!isVip) {
			throw new RuntimeException("Not a VIP User.");
		}
		
		return validateAccount(acc);
	}
	
}
