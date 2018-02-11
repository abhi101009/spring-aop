package com.aminfo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterFinallyAspect {

	@After("execution(* com.aminfo.aop.aspect.dao.AccountDao.validateAccount(..))")
	public void afterFinallyAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("== AFTER *FINALLY* Advice====> executing even error occuered or not.");
	}
	
}
