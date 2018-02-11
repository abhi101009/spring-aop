package com.aminfo.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aminfo.aop.aspect.dao.AccountDao;
import com.aminfo.aop.aspect.dao.MembershipDao;
import com.aminfo.aop.aspect.model.Account;

public class AppRunner {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		AccountDao dao = ctx.getBean("accountDao",AccountDao.class);
		MembershipDao membershipDao = ctx.getBean("membershipDao",MembershipDao.class);
		System.out.println("\n");
		dao.addAccount("1236542", 1);
		
		System.out.println("\n");
		dao.getAccountDetails();
		
		System.out.println("\n");
		dao.setAccountDetails();
		
		System.out.println("\n");
		membershipDao.addMember("Abhishek");
		
		System.out.println("\n");
		membershipDao.addAccount("1236542");
		
		System.out.println("\n");
		membershipDao.addsilyMembers("Abhishek");
		
		System.out.println("\n");
		List<Account> result = dao.findAllAccount();
		System.out.println("Result: "+ result.toString());
		
		System.out.println("\n");
		System.out.println("--------------Validateing Account------------");
		try {
			System.out.println("is valid account: "+dao.validateAccount(13));
			
			System.out.println("\n running With error:");
			System.out.println("is valid account: "+dao.validateAccount(9));
		} catch (Exception e) {
			System.out.println("Error: Exception on calling validateAcccount method.");
		}
		
		
		ctx.close();
	}
}
