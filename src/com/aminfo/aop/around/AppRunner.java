package com.aminfo.aop.around;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aminfo.aop.around.aspect.service.AccountService;
import com.aminfo.aop.aspect.model.Account;

public class AppRunner {
	
	private static Logger logger = Logger.getLogger(AppRunner.class.getName());
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		AccountService service = ctx.getBean("accountService",AccountService.class);
		
		logger.info("\n");
		String isValid = service.validateAccount(new Account(1246, "Abhi", true));
		
		logger.info("Result: "+isValid);
		
		
		logger.info("\n");
		String isValidVip = service.validateAccount(new Account(1246, "Abhi", true), false);
		logger.info("Result of VIP Users: "+isValidVip);
		
		
		ctx.close();
	}
}
