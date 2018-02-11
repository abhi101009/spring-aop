package com.aminfo.aop.joinpoint;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aminfo.aop.joinpoint.aspect.dao.AccountJoinPointDao;

public class AppRunner {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		AccountJoinPointDao joinpointAccount = ctx.getBean("accountJoinPointDao", AccountJoinPointDao.class);
		joinpointAccount.addAccount(123456, "Abhishek", true);
	}
}
