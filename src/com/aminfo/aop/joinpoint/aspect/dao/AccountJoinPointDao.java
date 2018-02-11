package com.aminfo.aop.joinpoint.aspect.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountJoinPointDao {

	public void addAccount(Integer accNo, String holderName, boolean enabled) {
		System.out.println("add Account called for accNo: "+ accNo);
	}
}
