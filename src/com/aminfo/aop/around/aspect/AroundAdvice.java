package com.aminfo.aop.around.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAdvice {

	private static Logger logger = Logger.getLogger(AroundAdvice.class.getName());
	
	@Around("execution(* com.aminfo.aop.around.aspect.service.AccountService.*(..))")
	public Object moniterTimeToEecuteMethods(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		String method = theProceedingJoinPoint.getSignature().toShortString();
		logger.info("\n ASPECT AROUND======> inside around advice method: "+ method);
		Object result = null;
		long startTime = System.currentTimeMillis();
		
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Throwable e) {
			logger.warning(e.getMessage());
			return "you can open account using on VIP account! don't worry.";
		}
		
		long endTime = System.currentTimeMillis();
		
		logger.info("total Time Taken by method: "+(endTime-startTime));
		
		return result;
	}
	
	@Before("execution(* com.aminfo.aop.around.aspect.service.AccountService.*(..))")
	public void beforeMethodExecution() {
		logger.info("== ASPECT BEFORE ====> before execution of method.");
	}
	
	@After("execution(* com.aminfo.aop.around.aspect.service.AccountService.*(..))")
	public void afterMethodExecution(JoinPoint theJoinPoint) {
		logger.info("== ASPECT AFTER ====> after execution of method.");
	}
}
