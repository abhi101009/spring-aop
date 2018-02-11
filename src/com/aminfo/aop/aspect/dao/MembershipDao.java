package com.aminfo.aop.aspect.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

	public void addMember(String name) {
		System.out.println("Adding member name: " + name +"\n");
	}
	
	public void addAccount(String accNo) {
		System.out.println(getClass().getName() + " Adding acount: " + accNo +"\n");
	}
	
	public void addsilyMembers(String name) {
		
		System.out.println(getClass().getName() + ": Adding sily members name: "+name +"\n");
	
	}
}
